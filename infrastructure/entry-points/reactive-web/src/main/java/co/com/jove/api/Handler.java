package co.com.jove.api;

import co.com.jove.api.dto.CreateUserDTO;
import co.com.jove.api.dto.UserDTO;
import co.com.jove.api.mapper.UserDTOMapperImpl;
import co.com.jove.model.user.exception.EmailDuplException;
import co.com.jove.usecase.user.UserUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static co.com.jove.model.constants.LogConstants.MESSAGE_HANDLER;
import static co.com.jove.model.constants.LogConstants.MESSAGE_SAVED_USER;

@Component
@RequiredArgsConstructor
public class Handler {

    private final Logger logger = LoggerFactory.getLogger(Handler.class);

    private final UserUseCase userUseCase;
    private final RequestValidator requestValidator;
    private final UserDTOMapperImpl userDTOMapper;
    private final ObjectMapper objectMapper;

    public Mono<ServerResponse> saveUserHandler(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(CreateUserDTO.class)
                .doOnNext(data->logger.info(MESSAGE_HANDLER ,data.toString()))
                .flatMap(requestValidator::validateData)
                .map(userDTOMapper::toModel)
                .flatMap(userUseCase::saveUser)
                .flatMap(savedUser -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(savedUser))
                .doOnSuccess(data->logger.info(MESSAGE_SAVED_USER,data))
                .onErrorResume(EmailDuplException.class, this::emailFound)
                .onErrorResume(ConstraintViolationException.class, this::badRequest);
    }
    private Mono<ServerResponse> badRequest(ConstraintViolationException ex) {
        var errors = ex.getConstraintViolations().stream()
                .collect(Collectors.toMap(v -> v.getPropertyPath().toString(),
                        ConstraintViolation::getMessage,
                        (a,b)->a, LinkedHashMap::new));
        return ServerResponse.badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(Map.of("code","validation_error", "errors", errors));
    }

    private Mono<ServerResponse> emailFound(EmailDuplException ex) {
        return ServerResponse.status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(Map.of(
                        "code", "duplicated_email",
                        "message", "El email ya esta siendo utilizado",
                        "field", "email"
                ));
    }




}

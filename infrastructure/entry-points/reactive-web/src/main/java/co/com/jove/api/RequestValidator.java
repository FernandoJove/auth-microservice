package co.com.jove.api;

import jakarta.validation.ConstraintViolationException;

import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static co.com.jove.model.constants.LogConstants.*;


@Component
@RequiredArgsConstructor
public class RequestValidator {
    private final Validator validator;

    private final Logger logger = LoggerFactory.getLogger(Validator.class);
    public<T> Mono <T> validateData( T dto) {

        return Mono.defer(()->{
            var violations = validator.validate(dto);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            return Mono.just(dto);
        })
                .doOnError(data->logger.error(MESSAGE_ERROR_IN_VALIDATIONS , dto))
                .doOnNext(data->logger.info(MESSAGE_VALID ,dto));

    }
}

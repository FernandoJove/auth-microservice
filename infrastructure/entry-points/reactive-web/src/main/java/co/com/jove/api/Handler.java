package co.com.jove.api;

import co.com.jove.model.user.User;
import co.com.jove.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class Handler {

    private final UserUseCase userUseCase;

    public Mono<ServerResponse> listenSaveUser(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(User.class)
                .flatMap(userUseCase::saveUser)
                .flatMap(savedTask -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(savedTask));
    }

}

package co.com.jove.api;

import jakarta.validation.ConstraintViolationException;

import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class RequestValidator {
    private final Validator validator;

    public<T> Mono <T> validateData( T dto) {
        /**
            Con defer crea un Mono perezoso, evita que el flujo arranque antes de que llegue la data
         */
        return Mono.defer(()->{
            var violations = validator.validate(dto);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            return Mono.just(dto);
        });

    }
}

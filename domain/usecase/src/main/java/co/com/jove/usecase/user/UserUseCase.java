package co.com.jove.usecase.user;

import co.com.jove.model.constants.DefaultValues;
import co.com.jove.model.user.User;
import co.com.jove.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;

    public Mono<User> saveUser(User user) {
       if (isNullValues(user.getIdRole())) user.setIdRole(UUID.fromString(DefaultValues.DEFAULT_ROLE));
       if (isNullValues(user.getCreatedAt())) user.setCreatedAt(LocalDate.now());
       if (isNullValues(user.getUpdatedAt())) user.setUpdatedAt(LocalDate.now());

       return userRepository.saveUser(user);
    }

    private <T> boolean isNullValues(T value){
        return Boolean.TRUE.equals(Objects.isNull(value));
    }
}

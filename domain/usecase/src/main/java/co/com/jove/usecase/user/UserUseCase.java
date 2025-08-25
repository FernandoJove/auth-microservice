package co.com.jove.usecase.user;

import co.com.jove.model.user.User;
import co.com.jove.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;

    public Mono<User> saveUser(User user) {
        user.setUpdatedAt(LocalDate.now());
        user.setCreatedAt(LocalDate.now());
       return userRepository.saveUser(user);
    }
}

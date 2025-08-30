package co.com.jove.model.user.gateways;

import co.com.jove.model.user.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> saveUser(User user);

    Mono<Boolean> validateUserByEmail(String email);
}

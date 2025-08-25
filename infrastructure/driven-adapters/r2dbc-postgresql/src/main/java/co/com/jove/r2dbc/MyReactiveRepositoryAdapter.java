package co.com.jove.r2dbc;

import co.com.jove.model.user.User;
import co.com.jove.model.user.exception.EmailDuplException;
import co.com.jove.r2dbc.entity.UserEntity;
import co.com.jove.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public class MyReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        User,
        UserEntity,
        UUID,
        UserRepository
> implements co.com.jove.model.user.gateways.UserRepository {
    public MyReactiveRepositoryAdapter(UserRepository userRepository, ObjectMapper mapper) {
        super(userRepository, mapper, entity -> mapper.map(entity, User.class));
    }

    @Override
    public Mono<User> saveUser(User user) {
        return super.save(user)
                .onErrorMap(DuplicateKeyException.class,ex -> new EmailDuplException(user.getEmail()));
    }
}

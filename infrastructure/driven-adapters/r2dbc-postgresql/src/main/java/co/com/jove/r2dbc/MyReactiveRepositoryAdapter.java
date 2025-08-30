package co.com.jove.r2dbc;

import co.com.jove.model.user.User;
import co.com.jove.model.user.exception.EmailDuplException;
import co.com.jove.model.user.gateways.UserRepository;
import co.com.jove.r2dbc.entity.UserEntity;
import co.com.jove.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static co.com.jove.model.constants.LogConstants.FOUND_USER_BY_EMAIL;
import static co.com.jove.model.constants.LogConstants.MESSAGE_ATTEMPT_TO_SAVE;

@Repository
public class MyReactiveRepositoryAdapter extends ReactiveAdapterOperations< User, UserEntity, UUID, UserReactiveRepository> implements UserRepository {

    private final Logger logger = LoggerFactory.getLogger(MyReactiveRepositoryAdapter.class);

    public MyReactiveRepositoryAdapter(UserReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, entity -> mapper.map(entity, User.class));

    }

    @Override
    public Mono<User> saveUser(User user) {
        return super.save(user)
                .doOnNext(data->logger.info( MESSAGE_ATTEMPT_TO_SAVE , user))
                .onErrorMap(DuplicateKeyException.class,ex -> new EmailDuplException(user.getEmail()));
    }

    @Override
    public Mono<Boolean> validateUserByEmail(String email) {
        User user =new User(email);
        return super.findByExample(user)
                .doOnNext(exists -> logger.info(FOUND_USER_BY_EMAIL, email))
                .next()
                .map(u -> true)
                .defaultIfEmpty(false);
    }


}

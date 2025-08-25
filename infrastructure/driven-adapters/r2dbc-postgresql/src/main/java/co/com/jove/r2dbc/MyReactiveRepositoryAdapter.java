package co.com.jove.r2dbc;

import co.com.jove.model.user.User;
import co.com.jove.model.user.gateways.UserRepository;
import co.com.jove.r2dbc.entity.UserEntity;
import co.com.jove.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public class MyReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        User,
        UserEntity,
        String,
    MyReactiveRepository
> implements UserRepository {
    public MyReactiveRepositoryAdapter(MyReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, entity -> mapper.map(entity, User.class));
    }

    @Override
    public Mono<User> saveUser(User user) {
        return super.save(user);
    }
}

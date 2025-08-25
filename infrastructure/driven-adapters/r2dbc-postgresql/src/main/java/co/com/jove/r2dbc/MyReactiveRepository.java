package co.com.jove.r2dbc;

import co.com.jove.r2dbc.entity.UserEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MyReactiveRepository extends ReactiveCrudRepository<UserEntity, String>, ReactiveQueryByExampleExecutor<UserEntity> {

}

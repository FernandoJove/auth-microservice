package co.com.jove.api;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
@RequiredArgsConstructor
public class RouterRest {
    private static  final String PATH="/api/v1";
    private static  final String USERS="/usuarios";


       
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return RouterFunctions.route()
                .path(PATH,v1->
                        v1.path(USERS,users->
                                users.POST("", RequestPredicates.accept
                                        (MediaType.APPLICATION_JSON), handler::listenSaveUser)))
                .build();
    }


}

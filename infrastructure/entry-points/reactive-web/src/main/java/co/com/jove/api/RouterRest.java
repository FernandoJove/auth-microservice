package co.com.jove.api;

import co.com.jove.api.config.UserPath;
import co.com.jove.api.dto.UserDTO;
import co.com.jove.model.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;



@Configuration
@RequiredArgsConstructor
public class RouterRest {


    @RouterOperations({
            @RouterOperation(
                    path = UserPath.USERS,
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.POST,
                    beanClass = Handler.class,
                    beanMethod = "saveUserHandler",
                    operation = @Operation(
                            operationId = "Save user ",
                            summary = "Endpoint to save user data for the first time",
                            responses = {
                                    @ApiResponse(responseCode = "201", description = "User creation",
                                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = User.class),
                                                    examples = {
                                                            @ExampleObject(name = "created",
                                                                    value = """
                                                                            {
                                                                                "name":"Paty",
                                                                                "lastname":"Ruiz",
                                                                                "email":"s2445453w4434qw3@gmail.com",
                                                                                "dni":1234678,
                                                                                "phoneNumber":123456789,
                                                                                "password":"Secreta123",
                                                                                "salary": 10
                                                                              }
                      """)
                                                    })),
                                    @ApiResponse(responseCode = "400", description = "Invalid request by uncompleted fields",
                                            content = @Content(mediaType = "application/problem+json",
                                                    schema = @Schema(implementation = UserDTO.class),
                                                    examples = @ExampleObject(name = "bad-request",
                                                            value = """
                                                                    {
                                                                        "name":"",
                                                                        "lastname":"",
                                                                        "email":"",
                                                                        "dni":,
                                                                        "phoneNumber":,
                                                                        "password":"",
                                                                        "salary": 10
                                                                      }
                  """)))}
                    )
            )
    })
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return RouterFunctions.route()
                .POST(UserPath.USERS,handler::saveUserHandler)
                .build();
    }


}

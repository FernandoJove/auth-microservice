package co.com.jove.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

public final class UserPath {
    public static  final String PATH="/api/v1";
    public static  final String USERS=PATH+"/usuarios";

}

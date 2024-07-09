package sfy.option.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "jwt.secret")
public class PropertiesConfig {
    private String SALT;
    private long EXPIRE_MINUTES;

    private String HEADER_AUTH;
}

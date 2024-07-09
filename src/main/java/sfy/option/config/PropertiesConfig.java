package sfy.option.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "jwt.secret")
public class PropertiesConfig {
    private String SALT;

    @DurationUnit(ChronoUnit.DAYS)
    private Duration EXPIRE_DAY;

    private String HEADER_AUTH;
}

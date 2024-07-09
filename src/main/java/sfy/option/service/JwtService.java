package sfy.option.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sfy.option.config.PropertiesConfig;
import sfy.option.exception.UnauthorizedException;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final PropertiesConfig propertiesConfig;

    public <T> String create(String key, T data, String subject) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("regDate", System.currentTimeMillis())
                .setExpiration(getExpireTime())
                .setSubject(subject)
                .claim(key, data)
                .signWith(SignatureAlgorithm.HS256, generateKey())
                .compact();
    }

    private Date getExpireTime() {
        return Date.from(Instant.now().plus(propertiesConfig.getEXPIRE_DAY()));
    }

    private byte[] generateKey() {
        return propertiesConfig.getSALT().getBytes(StandardCharsets.UTF_8);
    }

    public boolean isUsable(String token) {
        try {
            Jwts.parser().setSigningKey(generateKey()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new UnauthorizedException();
        }
    }

    public Map<String, Object> getBody(String token) {
        return Jwts.parser().setSigningKey(generateKey()).parseClaimsJws(token).getBody();
    }
}

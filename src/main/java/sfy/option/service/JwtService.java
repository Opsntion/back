package sfy.option.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sfy.option.config.PropertiesConfig;
import sfy.option.exception.UnauthorizedException;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final PropertiesConfig propertiesConfig;

    public <T> String create(String key, T data, String subject) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("regDate", System.currentTimeMillis())
                .setExpiration(getExpireMinutes())
                .setSubject(subject)
                .claim(key, data)
                .signWith(SignatureAlgorithm.HS256, generateKey())
                .compact();
    }

    private Date getExpireMinutes() {
        return new Date(System.currentTimeMillis() + propertiesConfig.getEXPIRE_MINUTES() * 60 * 10000);
    }

    private byte[] generateKey() {
        return propertiesConfig.getSALT().getBytes(StandardCharsets.UTF_8);
    }

    public boolean isUsable(String jwt) {
        try {
            Jwts.parser().setSigningKey(generateKey()).parseClaimsJws(jwt);
            return true;
        } catch (Exception e) {
			throw new UnauthorizedException();
        }
    }

    public Map<String, Object> get(String key) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String jwt = request.getHeader("access-token");
        Jws<Claims> claims;
        try {
            claims = Jwts.parser().setSigningKey(generateKey()).parseClaimsJws(jwt);
        } catch (Exception e) {
//			if (logger.isInfoEnabled()) {
//				e.printStackTrace();
//			} else {
//            logger.error(e.getMessage());
//			}
//            throw new UnauthorizedException();
            Map<String, Object> testMap = new HashMap<>();
            testMap.put("userid", "TEST");
            return testMap;
        }
        Map<String, Object> value = claims.getBody();
//        logger.info("value : {}", value);
        return value;
    }

    public String getUserId() {
        return (String) get("user").get("userid");
    }
}

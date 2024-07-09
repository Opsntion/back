package sfy.option.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import sfy.option.config.PropertiesConfig;
import sfy.option.exception.UnauthorizedException;
import sfy.option.service.JwtService;

@Component
@RequiredArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {

    private final JwtService jwtService;
    private final PropertiesConfig propertiesConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        final String token = request.getHeader(propertiesConfig.getHEADER_AUTH());

        if (token == null || !jwtService.isUsable(token)) {
            throw new UnauthorizedException();
        }

        return true;
    }
}

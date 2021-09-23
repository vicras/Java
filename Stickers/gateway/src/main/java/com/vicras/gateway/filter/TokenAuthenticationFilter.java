package com.vicras.gateway.filter;

import com.vicras.gateway.service.AuthService;
import com.vicras.proto_gen.auth.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static java.util.Objects.isNull;

/**
 * @author viktar hraskou
 */
@Component
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends GenericFilterBean {

    private final String tokenHeader = "token";
    private final AuthService authService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final String token = ((HttpServletRequest) request).getHeader(this.tokenHeader);
        if (isNull(token)) {
            chain.doFilter(request, response);
            return;
        }

        if (authService.isTokenValid(token)) {
            User user = authService.getUserByToken(token);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                    user.getId(), "", null
            ));
        }
        chain.doFilter(request, response);
    }
}


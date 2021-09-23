package com.vicras.users.service.impl;

import com.vicras.users.domain.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.util.Objects.isNull;

/**
 * @author viktar hraskou
 */
@Component
public class JWTService {


    private final String USER_LOGIN = "user_login";

    @Value("${token.expire.minutes}")
    private int tokenMinutesAlive;

    @Value("${token.secret}")
    private String key;

    public String getToken(User user) {

        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.claim(USER_LOGIN, user.getLogin());
        jwtBuilder.setIssuer(String.valueOf(user.getId()));
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + tokenMinutesAlive * 60000L));
        return jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact();
    }

    public boolean isValidToken(String token) {
        DefaultClaims claims;
        try {
            try {
                claims = (DefaultClaims) Jwts.parser().setSigningKey(key).parse(token).getBody();
            } catch (Exception ex) {
                throw new AuthenticationServiceException("Token corrupted");
            }

            if (isNull(claims.getExpiration())) {
                throw new AuthenticationServiceException("Invalid token");
            }

            Date expiredDate = claims.getExpiration();
            if (!expiredDate.after(new Date())) {
                throw new AuthenticationServiceException("Token expired date error");
            }
        } catch (AuthenticationServiceException e) {
            return false;
        }

        return true;
    }

    public Long getUserIdIfTokenValid(String token) {
        if (isValidToken(token)) {
            var claims = (DefaultClaims) Jwts.parser().setSigningKey(key).parse(token).getBody();
            return Long.parseLong(claims.getIssuer());
        }
        return null;
    }
}

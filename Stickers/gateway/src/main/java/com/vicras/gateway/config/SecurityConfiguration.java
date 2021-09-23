package com.vicras.gateway.config;

import io.grpc.CallCredentials;
import net.devh.boot.grpc.client.security.CallCredentialsHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author viktar hraskou
 */
@Configuration(proxyBeanMethods = false)
public class SecurityConfiguration {

    @Value("${grpc.user}")
    private String username = "user";

    @Value("${grpc.password}")
    private String password = "password";

    @Bean
    CallCredentials grpcCredentials() {
        return CallCredentialsHelper.basicAuth(username, password);
    }

}
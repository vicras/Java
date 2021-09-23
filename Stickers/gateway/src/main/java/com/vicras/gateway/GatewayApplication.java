package com.vicras.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;

@SpringBootApplication
@EnableWebSecurity
@RequiredArgsConstructor
public class GatewayApplication extends WebSecurityConfigurerAdapter {

    private final Filter tokenAuthenticationFilter;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin().and()
                .csrf()
                .disable()
                .authorizeRequests().antMatchers("/gate/**").authenticated().and()
                .addFilterAfter(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

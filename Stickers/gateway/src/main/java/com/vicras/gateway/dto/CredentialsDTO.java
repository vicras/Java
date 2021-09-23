package com.vicras.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

/**
 * @author viktar hraskou
 */
@Value
public class CredentialsDTO {

    @JsonProperty("password")
    private String password;

    @JsonProperty("login")
    private String login;

}

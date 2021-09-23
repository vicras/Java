package com.vicras.gateway.service;


import com.vicras.gateway.dto.CredentialsDTO;
import com.vicras.gateway.exception.AuthenticationException;
import com.vicras.proto_gen.auth.AuthControllerGrpc;
import com.vicras.proto_gen.auth.Credentials;
import com.vicras.proto_gen.auth.Token;
import com.vicras.proto_gen.auth.User;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author viktar hraskou
 */
@Service
public class AuthService {

    @GrpcClient("user-grpc-server")
    private AuthControllerGrpc.AuthControllerBlockingStub authGrpcService;

    public String login(CredentialsDTO cred) {
        Credentials credentials = parseCredentials(cred);
        try {
            return authGrpcService.getToken(credentials).getToken();
        } catch (Exception e) {
            throw new AuthenticationException(e.toString());
        }
    }

    public void signIn(@RequestBody CredentialsDTO cred) {
        Credentials credentials = parseCredentials(cred);
        try {
            authGrpcService.saveUser(credentials);
        } catch (Exception e) {
            throw new AuthenticationException(e.toString());
        }
    }

    public boolean isTokenValid(String token) {
        try {
            return authGrpcService.isTokenValid(Token.newBuilder().setToken(token).build()).getValue();
        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage());
        }
    }

    public User getUserByToken(String token) {
        try {
            return authGrpcService.getUserByToken(Token.newBuilder().setToken(token).build());
        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage());
        }
    }

    @NotNull
    private Credentials parseCredentials(CredentialsDTO cred) {
        return Credentials.newBuilder().setLogin(cred.getLogin()).setPassword(cred.getPassword()).build();
    }

}

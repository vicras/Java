package com.vicras.users.contorller;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.vicras.proto_gen.auth.AuthControllerGrpc;
import com.vicras.proto_gen.auth.Credentials;
import com.vicras.proto_gen.auth.Login;
import com.vicras.proto_gen.auth.Token;
import com.vicras.proto_gen.auth.User;
import com.vicras.users.service.UserService;
import com.vicras.users.service.impl.JWTService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.security.access.annotation.Secured;

/**
 * @author viktar hraskou
 */
@GrpcService
@RequiredArgsConstructor
public class AuthGrpcController extends AuthControllerGrpc.AuthControllerImplBase {

    private final UserService userService;
    private final JWTService jwtService;

    @Override
    public void getUserByToken(Token request, StreamObserver<User> responseObserver) {
        Long userId = jwtService.getUserIdIfTokenValid(request.getToken());
        com.vicras.users.domain.User user = userService.getUserById(userId);
        responseObserver.onNext(getUser(user));
        responseObserver.onCompleted();
    }

    @Override
    public void getUserByLogin(Login request, StreamObserver<User> responseObserver) {
        try {
            var userByLogin = userService.getUserByLogin(request.getLogin());
            User ans = getUser(userByLogin);
            responseObserver.onNext(ans);
            responseObserver.onCompleted();
        }catch (RuntimeException e){
            responseObserver.onError(e);
        }
    }

    @Override
    public void saveUser(Credentials request, StreamObserver<Empty> responseObserver) {
        userService.saveUser(request.getLogin(), request.getPassword());
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override

    public void getToken(Credentials request, StreamObserver<Token> responseObserver) {
        try {
            String token = userService.getToken(request.getLogin(), request.getPassword());
            responseObserver.onNext(Token.newBuilder().setToken(token).build());
            responseObserver.onCompleted();
        }catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    @Secured("ROLE_USER")
    public void isTokenValid(Token request, StreamObserver<BoolValue> responseObserver) {
        try {
            var isValid = userService.isTokenValid(request.getToken());
            responseObserver.onNext(BoolValue.of(isValid));
            responseObserver.onCompleted();
        }catch (Exception e){
            responseObserver.onError(e);
        }
    }

    @NotNull
    private User getUser(com.vicras.users.domain.User user) {
        return User.newBuilder()
                .setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .setId(user.getId().toString())
                .build();
    }
}

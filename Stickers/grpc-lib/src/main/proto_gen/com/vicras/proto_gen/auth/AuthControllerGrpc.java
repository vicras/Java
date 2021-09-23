package com.vicras.proto_gen.auth;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: auth.proto")
public final class AuthControllerGrpc {

  private AuthControllerGrpc() {}

  public static final String SERVICE_NAME = "AuthController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Login,
      com.vicras.proto_gen.auth.User> getGetUserByLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUserByLogin",
      requestType = com.vicras.proto_gen.auth.Login.class,
      responseType = com.vicras.proto_gen.auth.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Login,
      com.vicras.proto_gen.auth.User> getGetUserByLoginMethod() {
    io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Login, com.vicras.proto_gen.auth.User> getGetUserByLoginMethod;
    if ((getGetUserByLoginMethod = AuthControllerGrpc.getGetUserByLoginMethod) == null) {
      synchronized (AuthControllerGrpc.class) {
        if ((getGetUserByLoginMethod = AuthControllerGrpc.getGetUserByLoginMethod) == null) {
          AuthControllerGrpc.getGetUserByLoginMethod = getGetUserByLoginMethod = 
              io.grpc.MethodDescriptor.<com.vicras.proto_gen.auth.Login, com.vicras.proto_gen.auth.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AuthController", "getUserByLogin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vicras.proto_gen.auth.Login.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vicras.proto_gen.auth.User.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthControllerMethodDescriptorSupplier("getUserByLogin"))
                  .build();
          }
        }
     }
     return getGetUserByLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Token,
      com.vicras.proto_gen.auth.User> getGetUserByTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUserByToken",
      requestType = com.vicras.proto_gen.auth.Token.class,
      responseType = com.vicras.proto_gen.auth.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Token,
      com.vicras.proto_gen.auth.User> getGetUserByTokenMethod() {
    io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Token, com.vicras.proto_gen.auth.User> getGetUserByTokenMethod;
    if ((getGetUserByTokenMethod = AuthControllerGrpc.getGetUserByTokenMethod) == null) {
      synchronized (AuthControllerGrpc.class) {
        if ((getGetUserByTokenMethod = AuthControllerGrpc.getGetUserByTokenMethod) == null) {
          AuthControllerGrpc.getGetUserByTokenMethod = getGetUserByTokenMethod = 
              io.grpc.MethodDescriptor.<com.vicras.proto_gen.auth.Token, com.vicras.proto_gen.auth.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AuthController", "getUserByToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vicras.proto_gen.auth.Token.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vicras.proto_gen.auth.User.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthControllerMethodDescriptorSupplier("getUserByToken"))
                  .build();
          }
        }
     }
     return getGetUserByTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Credentials,
      com.google.protobuf.Empty> getSaveUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveUser",
      requestType = com.vicras.proto_gen.auth.Credentials.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Credentials,
      com.google.protobuf.Empty> getSaveUserMethod() {
    io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Credentials, com.google.protobuf.Empty> getSaveUserMethod;
    if ((getSaveUserMethod = AuthControllerGrpc.getSaveUserMethod) == null) {
      synchronized (AuthControllerGrpc.class) {
        if ((getSaveUserMethod = AuthControllerGrpc.getSaveUserMethod) == null) {
          AuthControllerGrpc.getSaveUserMethod = getSaveUserMethod = 
              io.grpc.MethodDescriptor.<com.vicras.proto_gen.auth.Credentials, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AuthController", "saveUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vicras.proto_gen.auth.Credentials.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthControllerMethodDescriptorSupplier("saveUser"))
                  .build();
          }
        }
     }
     return getSaveUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Credentials,
      com.vicras.proto_gen.auth.Token> getGetTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getToken",
      requestType = com.vicras.proto_gen.auth.Credentials.class,
      responseType = com.vicras.proto_gen.auth.Token.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Credentials,
      com.vicras.proto_gen.auth.Token> getGetTokenMethod() {
    io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Credentials, com.vicras.proto_gen.auth.Token> getGetTokenMethod;
    if ((getGetTokenMethod = AuthControllerGrpc.getGetTokenMethod) == null) {
      synchronized (AuthControllerGrpc.class) {
        if ((getGetTokenMethod = AuthControllerGrpc.getGetTokenMethod) == null) {
          AuthControllerGrpc.getGetTokenMethod = getGetTokenMethod = 
              io.grpc.MethodDescriptor.<com.vicras.proto_gen.auth.Credentials, com.vicras.proto_gen.auth.Token>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AuthController", "getToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vicras.proto_gen.auth.Credentials.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vicras.proto_gen.auth.Token.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthControllerMethodDescriptorSupplier("getToken"))
                  .build();
          }
        }
     }
     return getGetTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Token,
      com.google.protobuf.BoolValue> getIsTokenValidMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "isTokenValid",
      requestType = com.vicras.proto_gen.auth.Token.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Token,
      com.google.protobuf.BoolValue> getIsTokenValidMethod() {
    io.grpc.MethodDescriptor<com.vicras.proto_gen.auth.Token, com.google.protobuf.BoolValue> getIsTokenValidMethod;
    if ((getIsTokenValidMethod = AuthControllerGrpc.getIsTokenValidMethod) == null) {
      synchronized (AuthControllerGrpc.class) {
        if ((getIsTokenValidMethod = AuthControllerGrpc.getIsTokenValidMethod) == null) {
          AuthControllerGrpc.getIsTokenValidMethod = getIsTokenValidMethod = 
              io.grpc.MethodDescriptor.<com.vicras.proto_gen.auth.Token, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AuthController", "isTokenValid"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vicras.proto_gen.auth.Token.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthControllerMethodDescriptorSupplier("isTokenValid"))
                  .build();
          }
        }
     }
     return getIsTokenValidMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthControllerStub newStub(io.grpc.Channel channel) {
    return new AuthControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AuthControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuthControllerFutureStub(channel);
  }

  /**
   */
  public static abstract class AuthControllerImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUserByLogin(com.vicras.proto_gen.auth.Login request,
        io.grpc.stub.StreamObserver<com.vicras.proto_gen.auth.User> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserByLoginMethod(), responseObserver);
    }

    /**
     */
    public void getUserByToken(com.vicras.proto_gen.auth.Token request,
        io.grpc.stub.StreamObserver<com.vicras.proto_gen.auth.User> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserByTokenMethod(), responseObserver);
    }

    /**
     */
    public void saveUser(com.vicras.proto_gen.auth.Credentials request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveUserMethod(), responseObserver);
    }

    /**
     */
    public void getToken(com.vicras.proto_gen.auth.Credentials request,
        io.grpc.stub.StreamObserver<com.vicras.proto_gen.auth.Token> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTokenMethod(), responseObserver);
    }

    /**
     */
    public void isTokenValid(com.vicras.proto_gen.auth.Token request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getIsTokenValidMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserByLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.vicras.proto_gen.auth.Login,
                com.vicras.proto_gen.auth.User>(
                  this, METHODID_GET_USER_BY_LOGIN)))
          .addMethod(
            getGetUserByTokenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.vicras.proto_gen.auth.Token,
                com.vicras.proto_gen.auth.User>(
                  this, METHODID_GET_USER_BY_TOKEN)))
          .addMethod(
            getSaveUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.vicras.proto_gen.auth.Credentials,
                com.google.protobuf.Empty>(
                  this, METHODID_SAVE_USER)))
          .addMethod(
            getGetTokenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.vicras.proto_gen.auth.Credentials,
                com.vicras.proto_gen.auth.Token>(
                  this, METHODID_GET_TOKEN)))
          .addMethod(
            getIsTokenValidMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.vicras.proto_gen.auth.Token,
                com.google.protobuf.BoolValue>(
                  this, METHODID_IS_TOKEN_VALID)))
          .build();
    }
  }

  /**
   */
  public static final class AuthControllerStub extends io.grpc.stub.AbstractStub<AuthControllerStub> {
    private AuthControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthControllerStub(channel, callOptions);
    }

    /**
     */
    public void getUserByLogin(com.vicras.proto_gen.auth.Login request,
        io.grpc.stub.StreamObserver<com.vicras.proto_gen.auth.User> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserByLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserByToken(com.vicras.proto_gen.auth.Token request,
        io.grpc.stub.StreamObserver<com.vicras.proto_gen.auth.User> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserByTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveUser(com.vicras.proto_gen.auth.Credentials request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getToken(com.vicras.proto_gen.auth.Credentials request,
        io.grpc.stub.StreamObserver<com.vicras.proto_gen.auth.Token> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isTokenValid(com.vicras.proto_gen.auth.Token request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsTokenValidMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthControllerBlockingStub extends io.grpc.stub.AbstractStub<AuthControllerBlockingStub> {
    private AuthControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthControllerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.vicras.proto_gen.auth.User getUserByLogin(com.vicras.proto_gen.auth.Login request) {
      return blockingUnaryCall(
          getChannel(), getGetUserByLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.vicras.proto_gen.auth.User getUserByToken(com.vicras.proto_gen.auth.Token request) {
      return blockingUnaryCall(
          getChannel(), getGetUserByTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty saveUser(com.vicras.proto_gen.auth.Credentials request) {
      return blockingUnaryCall(
          getChannel(), getSaveUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.vicras.proto_gen.auth.Token getToken(com.vicras.proto_gen.auth.Credentials request) {
      return blockingUnaryCall(
          getChannel(), getGetTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue isTokenValid(com.vicras.proto_gen.auth.Token request) {
      return blockingUnaryCall(
          getChannel(), getIsTokenValidMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthControllerFutureStub extends io.grpc.stub.AbstractStub<AuthControllerFutureStub> {
    private AuthControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthControllerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.vicras.proto_gen.auth.User> getUserByLogin(
        com.vicras.proto_gen.auth.Login request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserByLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.vicras.proto_gen.auth.User> getUserByToken(
        com.vicras.proto_gen.auth.Token request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserByTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> saveUser(
        com.vicras.proto_gen.auth.Credentials request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.vicras.proto_gen.auth.Token> getToken(
        com.vicras.proto_gen.auth.Credentials request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> isTokenValid(
        com.vicras.proto_gen.auth.Token request) {
      return futureUnaryCall(
          getChannel().newCall(getIsTokenValidMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_BY_LOGIN = 0;
  private static final int METHODID_GET_USER_BY_TOKEN = 1;
  private static final int METHODID_SAVE_USER = 2;
  private static final int METHODID_GET_TOKEN = 3;
  private static final int METHODID_IS_TOKEN_VALID = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_BY_LOGIN:
          serviceImpl.getUserByLogin((com.vicras.proto_gen.auth.Login) request,
              (io.grpc.stub.StreamObserver<com.vicras.proto_gen.auth.User>) responseObserver);
          break;
        case METHODID_GET_USER_BY_TOKEN:
          serviceImpl.getUserByToken((com.vicras.proto_gen.auth.Token) request,
              (io.grpc.stub.StreamObserver<com.vicras.proto_gen.auth.User>) responseObserver);
          break;
        case METHODID_SAVE_USER:
          serviceImpl.saveUser((com.vicras.proto_gen.auth.Credentials) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_TOKEN:
          serviceImpl.getToken((com.vicras.proto_gen.auth.Credentials) request,
              (io.grpc.stub.StreamObserver<com.vicras.proto_gen.auth.Token>) responseObserver);
          break;
        case METHODID_IS_TOKEN_VALID:
          serviceImpl.isTokenValid((com.vicras.proto_gen.auth.Token) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AuthControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.vicras.proto_gen.auth.Auth.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthController");
    }
  }

  private static final class AuthControllerFileDescriptorSupplier
      extends AuthControllerBaseDescriptorSupplier {
    AuthControllerFileDescriptorSupplier() {}
  }

  private static final class AuthControllerMethodDescriptorSupplier
      extends AuthControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthControllerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AuthControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthControllerFileDescriptorSupplier())
              .addMethod(getGetUserByLoginMethod())
              .addMethod(getGetUserByTokenMethod())
              .addMethod(getSaveUserMethod())
              .addMethod(getGetTokenMethod())
              .addMethod(getIsTokenValidMethod())
              .build();
        }
      }
    }
    return result;
  }
}

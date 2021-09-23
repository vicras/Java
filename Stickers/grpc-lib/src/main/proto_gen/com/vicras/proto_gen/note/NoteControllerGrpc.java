package com.vicras.proto_gen.note;

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
    comments = "Source: note.proto")
public final class NoteControllerGrpc {

  private NoteControllerGrpc() {}

  public static final String SERVICE_NAME = "NoteController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.vicras.proto_gen.note.Note,
      com.google.protobuf.Empty> getNewRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "newRecord",
      requestType = com.vicras.proto_gen.note.Note.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.vicras.proto_gen.note.Note,
      com.google.protobuf.Empty> getNewRecordMethod() {
    io.grpc.MethodDescriptor<com.vicras.proto_gen.note.Note, com.google.protobuf.Empty> getNewRecordMethod;
    if ((getNewRecordMethod = NoteControllerGrpc.getNewRecordMethod) == null) {
      synchronized (NoteControllerGrpc.class) {
        if ((getNewRecordMethod = NoteControllerGrpc.getNewRecordMethod) == null) {
          NoteControllerGrpc.getNewRecordMethod = getNewRecordMethod = 
              io.grpc.MethodDescriptor.<com.vicras.proto_gen.note.Note, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "NoteController", "newRecord"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vicras.proto_gen.note.Note.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new NoteControllerMethodDescriptorSupplier("newRecord"))
                  .build();
          }
        }
     }
     return getNewRecordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.vicras.proto_gen.note.Note> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getById",
      requestType = com.google.protobuf.Int64Value.class,
      responseType = com.vicras.proto_gen.note.Note.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.vicras.proto_gen.note.Note> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int64Value, com.vicras.proto_gen.note.Note> getGetByIdMethod;
    if ((getGetByIdMethod = NoteControllerGrpc.getGetByIdMethod) == null) {
      synchronized (NoteControllerGrpc.class) {
        if ((getGetByIdMethod = NoteControllerGrpc.getGetByIdMethod) == null) {
          NoteControllerGrpc.getGetByIdMethod = getGetByIdMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Int64Value, com.vicras.proto_gen.note.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "NoteController", "getById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int64Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vicras.proto_gen.note.Note.getDefaultInstance()))
                  .setSchemaDescriptor(new NoteControllerMethodDescriptorSupplier("getById"))
                  .build();
          }
        }
     }
     return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.vicras.proto_gen.note.Notes> getGetAllByUserIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllByUserId",
      requestType = com.google.protobuf.Int64Value.class,
      responseType = com.vicras.proto_gen.note.Notes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.vicras.proto_gen.note.Notes> getGetAllByUserIdMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int64Value, com.vicras.proto_gen.note.Notes> getGetAllByUserIdMethod;
    if ((getGetAllByUserIdMethod = NoteControllerGrpc.getGetAllByUserIdMethod) == null) {
      synchronized (NoteControllerGrpc.class) {
        if ((getGetAllByUserIdMethod = NoteControllerGrpc.getGetAllByUserIdMethod) == null) {
          NoteControllerGrpc.getGetAllByUserIdMethod = getGetAllByUserIdMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Int64Value, com.vicras.proto_gen.note.Notes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "NoteController", "getAllByUserId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int64Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.vicras.proto_gen.note.Notes.getDefaultInstance()))
                  .setSchemaDescriptor(new NoteControllerMethodDescriptorSupplier("getAllByUserId"))
                  .build();
          }
        }
     }
     return getGetAllByUserIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.google.protobuf.Empty> getDeleteByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteById",
      requestType = com.google.protobuf.Int64Value.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.google.protobuf.Empty> getDeleteByIdMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int64Value, com.google.protobuf.Empty> getDeleteByIdMethod;
    if ((getDeleteByIdMethod = NoteControllerGrpc.getDeleteByIdMethod) == null) {
      synchronized (NoteControllerGrpc.class) {
        if ((getDeleteByIdMethod = NoteControllerGrpc.getDeleteByIdMethod) == null) {
          NoteControllerGrpc.getDeleteByIdMethod = getDeleteByIdMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Int64Value, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "NoteController", "deleteById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int64Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new NoteControllerMethodDescriptorSupplier("deleteById"))
                  .build();
          }
        }
     }
     return getDeleteByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NoteControllerStub newStub(io.grpc.Channel channel) {
    return new NoteControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NoteControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new NoteControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NoteControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new NoteControllerFutureStub(channel);
  }

  /**
   */
  public static abstract class NoteControllerImplBase implements io.grpc.BindableService {

    /**
     */
    public void newRecord(com.vicras.proto_gen.note.Note request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getNewRecordMethod(), responseObserver);
    }

    /**
     */
    public void getById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.vicras.proto_gen.note.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    public void getAllByUserId(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.vicras.proto_gen.note.Notes> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllByUserIdMethod(), responseObserver);
    }

    /**
     */
    public void deleteById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteByIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getNewRecordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.vicras.proto_gen.note.Note,
                com.google.protobuf.Empty>(
                  this, METHODID_NEW_RECORD)))
          .addMethod(
            getGetByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int64Value,
                com.vicras.proto_gen.note.Note>(
                  this, METHODID_GET_BY_ID)))
          .addMethod(
            getGetAllByUserIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int64Value,
                com.vicras.proto_gen.note.Notes>(
                  this, METHODID_GET_ALL_BY_USER_ID)))
          .addMethod(
            getDeleteByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int64Value,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class NoteControllerStub extends io.grpc.stub.AbstractStub<NoteControllerStub> {
    private NoteControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NoteControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NoteControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NoteControllerStub(channel, callOptions);
    }

    /**
     */
    public void newRecord(com.vicras.proto_gen.note.Note request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getNewRecordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.vicras.proto_gen.note.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllByUserId(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.vicras.proto_gen.note.Notes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllByUserIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class NoteControllerBlockingStub extends io.grpc.stub.AbstractStub<NoteControllerBlockingStub> {
    private NoteControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NoteControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NoteControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NoteControllerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty newRecord(com.vicras.proto_gen.note.Note request) {
      return blockingUnaryCall(
          getChannel(), getNewRecordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.vicras.proto_gen.note.Note getById(com.google.protobuf.Int64Value request) {
      return blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.vicras.proto_gen.note.Notes getAllByUserId(com.google.protobuf.Int64Value request) {
      return blockingUnaryCall(
          getChannel(), getGetAllByUserIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteById(com.google.protobuf.Int64Value request) {
      return blockingUnaryCall(
          getChannel(), getDeleteByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class NoteControllerFutureStub extends io.grpc.stub.AbstractStub<NoteControllerFutureStub> {
    private NoteControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NoteControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NoteControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NoteControllerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> newRecord(
        com.vicras.proto_gen.note.Note request) {
      return futureUnaryCall(
          getChannel().newCall(getNewRecordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.vicras.proto_gen.note.Note> getById(
        com.google.protobuf.Int64Value request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.vicras.proto_gen.note.Notes> getAllByUserId(
        com.google.protobuf.Int64Value request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllByUserIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteById(
        com.google.protobuf.Int64Value request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_NEW_RECORD = 0;
  private static final int METHODID_GET_BY_ID = 1;
  private static final int METHODID_GET_ALL_BY_USER_ID = 2;
  private static final int METHODID_DELETE_BY_ID = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NoteControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NoteControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NEW_RECORD:
          serviceImpl.newRecord((com.vicras.proto_gen.note.Note) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.google.protobuf.Int64Value) request,
              (io.grpc.stub.StreamObserver<com.vicras.proto_gen.note.Note>) responseObserver);
          break;
        case METHODID_GET_ALL_BY_USER_ID:
          serviceImpl.getAllByUserId((com.google.protobuf.Int64Value) request,
              (io.grpc.stub.StreamObserver<com.vicras.proto_gen.note.Notes>) responseObserver);
          break;
        case METHODID_DELETE_BY_ID:
          serviceImpl.deleteById((com.google.protobuf.Int64Value) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class NoteControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NoteControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.vicras.proto_gen.note.NoteOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NoteController");
    }
  }

  private static final class NoteControllerFileDescriptorSupplier
      extends NoteControllerBaseDescriptorSupplier {
    NoteControllerFileDescriptorSupplier() {}
  }

  private static final class NoteControllerMethodDescriptorSupplier
      extends NoteControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NoteControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (NoteControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NoteControllerFileDescriptorSupplier())
              .addMethod(getNewRecordMethod())
              .addMethod(getGetByIdMethod())
              .addMethod(getGetAllByUserIdMethod())
              .addMethod(getDeleteByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}

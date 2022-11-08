package com.pigfarm.pig;

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
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: pig/pig.proto")
public final class PigServiceGrpc {

  private PigServiceGrpc() {}

  public static final String SERVICE_NAME = "pig.PigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.pigfarm.pig.HelloRequest,
      com.pigfarm.pig.HelloResponse> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = com.pigfarm.pig.HelloRequest.class,
      responseType = com.pigfarm.pig.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pigfarm.pig.HelloRequest,
      com.pigfarm.pig.HelloResponse> getSayHelloMethod() {
    io.grpc.MethodDescriptor<com.pigfarm.pig.HelloRequest, com.pigfarm.pig.HelloResponse> getSayHelloMethod;
    if ((getSayHelloMethod = PigServiceGrpc.getSayHelloMethod) == null) {
      synchronized (PigServiceGrpc.class) {
        if ((getSayHelloMethod = PigServiceGrpc.getSayHelloMethod) == null) {
          PigServiceGrpc.getSayHelloMethod = getSayHelloMethod = 
              io.grpc.MethodDescriptor.<com.pigfarm.pig.HelloRequest, com.pigfarm.pig.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "pig.PigService", "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pigfarm.pig.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pigfarm.pig.HelloResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PigServiceMethodDescriptorSupplier("SayHello"))
                  .build();
          }
        }
     }
     return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pigfarm.pig.PigsRequest,
      com.pigfarm.pig.PigsResponse> getFindPigsFromProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindPigsFromProduct",
      requestType = com.pigfarm.pig.PigsRequest.class,
      responseType = com.pigfarm.pig.PigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pigfarm.pig.PigsRequest,
      com.pigfarm.pig.PigsResponse> getFindPigsFromProductMethod() {
    io.grpc.MethodDescriptor<com.pigfarm.pig.PigsRequest, com.pigfarm.pig.PigsResponse> getFindPigsFromProductMethod;
    if ((getFindPigsFromProductMethod = PigServiceGrpc.getFindPigsFromProductMethod) == null) {
      synchronized (PigServiceGrpc.class) {
        if ((getFindPigsFromProductMethod = PigServiceGrpc.getFindPigsFromProductMethod) == null) {
          PigServiceGrpc.getFindPigsFromProductMethod = getFindPigsFromProductMethod = 
              io.grpc.MethodDescriptor.<com.pigfarm.pig.PigsRequest, com.pigfarm.pig.PigsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "pig.PigService", "FindPigsFromProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pigfarm.pig.PigsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pigfarm.pig.PigsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PigServiceMethodDescriptorSupplier("FindPigsFromProduct"))
                  .build();
          }
        }
     }
     return getFindPigsFromProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pigfarm.pig.ProductRequest,
      com.pigfarm.pig.ProductResponse> getFindProductsFromPigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindProductsFromPigs",
      requestType = com.pigfarm.pig.ProductRequest.class,
      responseType = com.pigfarm.pig.ProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pigfarm.pig.ProductRequest,
      com.pigfarm.pig.ProductResponse> getFindProductsFromPigsMethod() {
    io.grpc.MethodDescriptor<com.pigfarm.pig.ProductRequest, com.pigfarm.pig.ProductResponse> getFindProductsFromPigsMethod;
    if ((getFindProductsFromPigsMethod = PigServiceGrpc.getFindProductsFromPigsMethod) == null) {
      synchronized (PigServiceGrpc.class) {
        if ((getFindProductsFromPigsMethod = PigServiceGrpc.getFindProductsFromPigsMethod) == null) {
          PigServiceGrpc.getFindProductsFromPigsMethod = getFindProductsFromPigsMethod = 
              io.grpc.MethodDescriptor.<com.pigfarm.pig.ProductRequest, com.pigfarm.pig.ProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "pig.PigService", "FindProductsFromPigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pigfarm.pig.ProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pigfarm.pig.ProductResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PigServiceMethodDescriptorSupplier("FindProductsFromPigs"))
                  .build();
          }
        }
     }
     return getFindProductsFromPigsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PigServiceStub newStub(io.grpc.Channel channel) {
    return new PigServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PigServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PigServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PigServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PigServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PigServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(com.pigfarm.pig.HelloRequest request,
        io.grpc.stub.StreamObserver<com.pigfarm.pig.HelloResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    public void findPigsFromProduct(com.pigfarm.pig.PigsRequest request,
        io.grpc.stub.StreamObserver<com.pigfarm.pig.PigsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindPigsFromProductMethod(), responseObserver);
    }

    /**
     */
    public void findProductsFromPigs(com.pigfarm.pig.ProductRequest request,
        io.grpc.stub.StreamObserver<com.pigfarm.pig.ProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindProductsFromPigsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.pigfarm.pig.HelloRequest,
                com.pigfarm.pig.HelloResponse>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getFindPigsFromProductMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.pigfarm.pig.PigsRequest,
                com.pigfarm.pig.PigsResponse>(
                  this, METHODID_FIND_PIGS_FROM_PRODUCT)))
          .addMethod(
            getFindProductsFromPigsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.pigfarm.pig.ProductRequest,
                com.pigfarm.pig.ProductResponse>(
                  this, METHODID_FIND_PRODUCTS_FROM_PIGS)))
          .build();
    }
  }

  /**
   */
  public static final class PigServiceStub extends io.grpc.stub.AbstractStub<PigServiceStub> {
    private PigServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PigServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PigServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PigServiceStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(com.pigfarm.pig.HelloRequest request,
        io.grpc.stub.StreamObserver<com.pigfarm.pig.HelloResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findPigsFromProduct(com.pigfarm.pig.PigsRequest request,
        io.grpc.stub.StreamObserver<com.pigfarm.pig.PigsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindPigsFromProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findProductsFromPigs(com.pigfarm.pig.ProductRequest request,
        io.grpc.stub.StreamObserver<com.pigfarm.pig.ProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindProductsFromPigsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PigServiceBlockingStub extends io.grpc.stub.AbstractStub<PigServiceBlockingStub> {
    private PigServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PigServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PigServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PigServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.pigfarm.pig.HelloResponse sayHello(com.pigfarm.pig.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pigfarm.pig.PigsResponse findPigsFromProduct(com.pigfarm.pig.PigsRequest request) {
      return blockingUnaryCall(
          getChannel(), getFindPigsFromProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pigfarm.pig.ProductResponse findProductsFromPigs(com.pigfarm.pig.ProductRequest request) {
      return blockingUnaryCall(
          getChannel(), getFindProductsFromPigsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PigServiceFutureStub extends io.grpc.stub.AbstractStub<PigServiceFutureStub> {
    private PigServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PigServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PigServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PigServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pigfarm.pig.HelloResponse> sayHello(
        com.pigfarm.pig.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pigfarm.pig.PigsResponse> findPigsFromProduct(
        com.pigfarm.pig.PigsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFindPigsFromProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pigfarm.pig.ProductResponse> findProductsFromPigs(
        com.pigfarm.pig.ProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFindProductsFromPigsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_FIND_PIGS_FROM_PRODUCT = 1;
  private static final int METHODID_FIND_PRODUCTS_FROM_PIGS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PigServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PigServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.pigfarm.pig.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.pigfarm.pig.HelloResponse>) responseObserver);
          break;
        case METHODID_FIND_PIGS_FROM_PRODUCT:
          serviceImpl.findPigsFromProduct((com.pigfarm.pig.PigsRequest) request,
              (io.grpc.stub.StreamObserver<com.pigfarm.pig.PigsResponse>) responseObserver);
          break;
        case METHODID_FIND_PRODUCTS_FROM_PIGS:
          serviceImpl.findProductsFromPigs((com.pigfarm.pig.ProductRequest) request,
              (io.grpc.stub.StreamObserver<com.pigfarm.pig.ProductResponse>) responseObserver);
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

  private static abstract class PigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.pigfarm.pig.Pig.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PigService");
    }
  }

  private static final class PigServiceFileDescriptorSupplier
      extends PigServiceBaseDescriptorSupplier {
    PigServiceFileDescriptorSupplier() {}
  }

  private static final class PigServiceMethodDescriptorSupplier
      extends PigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PigServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PigServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PigServiceFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getFindPigsFromProductMethod())
              .addMethod(getFindProductsFromPigsMethod())
              .build();
        }
      }
    }
    return result;
  }
}

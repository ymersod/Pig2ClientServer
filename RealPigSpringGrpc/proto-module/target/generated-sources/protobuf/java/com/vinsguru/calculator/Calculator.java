// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: calculator/calculator.proto

package com.vinsguru.calculator;

public final class Calculator {
  private Calculator() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_calculator_Input_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_calculator_Input_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_calculator_Output_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_calculator_Output_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033calculator/calculator.proto\022\ncalculato" +
      "r\"\027\n\005Input\022\016\n\006number\030\001 \001(\005\"\030\n\006Output\022\016\n\006" +
      "result\030\001 \001(\0032\372\001\n\021CalculatorService\0228\n\rfi" +
      "ndFactorial\022\021.calculator.Input\032\022.calcula" +
      "tor.Output\"\000\022:\n\rgetAllDoubles\022\021.calculat" +
      "or.Input\032\022.calculator.Output\"\0000\001\0223\n\006sumA" +
      "ll\022\021.calculator.Input\032\022.calculator.Outpu" +
      "t\"\000(\001\022:\n\013playUpTo100\022\021.calculator.Input\032" +
      "\022.calculator.Output\"\000(\0010\001B\033\n\027com.vinsgur" +
      "u.calculatorP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_calculator_Input_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_calculator_Input_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_calculator_Input_descriptor,
        new java.lang.String[] { "Number", });
    internal_static_calculator_Output_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_calculator_Output_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_calculator_Output_descriptor,
        new java.lang.String[] { "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

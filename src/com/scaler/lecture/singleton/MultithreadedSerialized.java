package com.scaler.lecture.singleton;

import java.io.Serializable;

public class MultithreadedSerialized implements Serializable {

  // Private static instance variable
  private static volatile MultithreadedSerialized instance;

  // Private constructor to prevent instantiation
  private MultithreadedSerialized() {
    // Ensure that reflection can't create a new instance
    if (instance != null) {
      throw new IllegalStateException("Singleton instance already exists.");
    }
  }

  // Public method to provide access to the instance
  public static MultithreadedSerialized getInstance() {
    if (instance == null) {
      synchronized (MultithreadedSerialized.class) {
        if (instance == null) {
          instance = new MultithreadedSerialized();
        }
      }
    }
    return instance;
  }

  // Implement readResolve to maintain singleton after deserialization
  protected Object readResolve() {
    return getInstance();
  }
}

/*
Explanation:

The class Singleton implements Serializable to indicate that it can be serialized.

The instance variable instance is marked as volatile. This ensures that changes made by one thread are visible to all other threads. It also prevents reordering of instructions that might lead to incorrect behavior in a multi-threaded environment.

The private constructor prevents instantiation of the class from outside.

The getInstance() method is synchronized using a double-checked locking mechanism. This ensures that only one instance is created, even in a multi-threaded environment. The first check (if (instance == null)) is performed without synchronization for efficiency. If the instance is null, it then enters a synchronized block to create the instance.

The readResolve() method is implemented to ensure that deserialization does not create a new instance. It returns the existing singleton instance, thus maintaining the singleton pattern.

A check inside the constructor ensures that even if a singleton instance is created using reflection, it will throw an exception.
 */


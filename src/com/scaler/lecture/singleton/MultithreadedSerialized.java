package com.scaler.lecture.singleton;

import java.io.Serializable;

/*
 * Explanation:
 * The class Singleton implements Serializable to indicate that it can be serialized.
 * The instance variable instance is marked as volatile. This ensures that changes made by one thread are
 * visible to all other threads.
 * It also prevents reordering of instructions that might lead to incorrect behavior in a multi-threaded
 * environment.
 * The private constructor prevents instantiation of the class from outside.
 * The getInstance() method is synchronized using a double-checked locking mechanism.
 * This ensures that only one instance is created, even in a multi-threaded environment.
 * The first check (if (instance == null)) is performed without synchronization for efficiency.
 * If the instance is null, it then enters a synchronized block to create the instance.
 * The readResolve() method is implemented to ensure that deserialization does not create a new instance.
 * It returns the existing singleton instance, thus maintaining the singleton pattern.
 * A check inside the constructor ensures that even if a singleton instance is created using reflection, it
 * will throw an exception.
 * Here's what happens without implementing readResolve():
 * Deserialization: When an object of the Singleton class is deserialized, the default deserialization process
 * creates a new instance of the Singleton class, bypassing the constructor and other singleton initialization
 * mechanisms.
 * Multiple Instances: This means that instead of getting the existing singleton instance, a new instance will
 * be created every time the object is deserialized. As a result, the Singleton pattern's contract of having
 * only one instance throughout the application is violated.
 * Loss of Singleton Property: Without readResolve(), the deserialized object behaves like any other object
 * and does not maintain the Singleton property, leading to unexpected behavior in applications relying on
 * Singleton semantics.
 * To ensure that the Singleton pattern's integrity is preserved during deserialization, it's essential to
 * implement the readResolve() method, returning the singleton instance. By doing so, you explicitly control
 * the object creation process during deserialization and ensure that only one instance of the Singleton class
 * exists throughout the application, as intended.
 */

public class MultithreadedSerialized
    implements Serializable {

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
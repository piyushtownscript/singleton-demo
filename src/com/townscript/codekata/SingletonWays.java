package com.townscript.codekata;

public class SingletonWays {

  public static void main(String[] args) {

  }

}


class SingletonType1 {

  // why static? why final?
  private static final SingletonType1 instance = new SingletonType1();

  private SingletonType1() {}

  public static SingletonType1 getInstance() {
    return instance;
  }

  // Eager initialization, pros and cons
}


// 2nd option
class StaticBlockSingleton {

  private static StaticBlockSingleton instance;

  private StaticBlockSingleton() {}

  // static block initialization for exception handling
  static {

    instance = new StaticBlockSingleton();
  }

  public static StaticBlockSingleton getInstance() {
    return instance;
  }

  // same problems as eager
}


// 3 Lazy creation
class LazyInitializedSingleton {

  private static LazyInitializedSingleton instance;

  private LazyInitializedSingleton() {}

  public static LazyInitializedSingleton getInstance() {
    if (instance == null) {
      instance = new LazyInitializedSingleton();
    }
    return instance;
  }
  // when will it fail
}


// 4th Thread safe
class ThreadSafeSingleton {

  private static ThreadSafeSingleton instance;

  private ThreadSafeSingleton() {}

  public static synchronized ThreadSafeSingleton getInstance() {
    if (instance == null) {
      instance = new ThreadSafeSingleton();
    }
    return instance;
  }

  // issues here
}


// 5th most widely used
class ThreadSafeSingleton2 {

  private volatile static ThreadSafeSingleton2 instance;

  private ThreadSafeSingleton2() {}

  public ThreadSafeSingleton2 getInstance() {
    if (instance == null) {
      synchronized (ThreadSafeSingleton2.class) {
        if (instance == null) {
          instance = new ThreadSafeSingleton2();
        }
      }
    }
    return instance;
  }
  // volatile??

}


// 6th best one for some cases
class BestLazyTrick {
  private BestLazyTrick() {}

  private static class Helper {
    private static final BestLazyTrick INSTANCE = new BestLazyTrick();

  }

  public static BestLazyTrick getInstance() {
    return Helper.INSTANCE;
  }
}


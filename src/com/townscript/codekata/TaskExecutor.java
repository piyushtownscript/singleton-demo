package com.townscript.codekata;

public class TaskExecutor extends Thread {

  int wait;
  String name;

  public TaskExecutor(String name, int wait) {
    super();
    this.wait = wait;
    this.name = name;
  }

  @Override
  public void run() {
    TSObjectPool object = TSObjectPool.getInstance();
    System.out.println("Get Thread : " + name + " Object : " + object);
    try {
      sleep(wait);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Releasing Thread : " + name + " Object : " + object);
    object.release();

  }

}

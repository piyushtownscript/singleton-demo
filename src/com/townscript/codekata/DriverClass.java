package com.townscript.codekata;

public class DriverClass {

  public static final int SIZE = 5;

  public static void main(String[] args) {

    TaskExecutor task1 = new TaskExecutor("Thread 1", 1000);
    TaskExecutor task2 = new TaskExecutor("Thread 2", 7000);
    TaskExecutor task3 = new TaskExecutor("Thread 3", 10000);
    TaskExecutor task4 = new TaskExecutor("Thread 4", 3000);
    TaskExecutor task5 = new TaskExecutor("Thread 5", 2000);
    TaskExecutor task6 = new TaskExecutor("Thread 6", 10000);
    TaskExecutor task7 = new TaskExecutor("Thread 7", 2000);

    task1.start();
    task2.start();
    task3.start();
    task4.start();
    task5.start();
    task6.start();
    task7.start();
  }

}

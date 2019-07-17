package com.townscript.codekata;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TSObjectPool {

  private static int count = 0;
  private String identifier;

  private TSObjectPool() {
    count++;
    identifier = "ObjectPool-" + count;
  }

  @Override
  public String toString() {
    return identifier;
  }

  private static Queue<TSObjectPool> freePool = new LinkedList<>();
  private static Set<TSObjectPool> objectInUse = new HashSet<>();


  public static TSObjectPool getInstance() {

    synchronized (freePool) {

      if (freePool.isEmpty() && (objectInUse.size() == DriverClass.SIZE)) {
        try {
          freePool.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      if (!freePool.isEmpty()) {
        TSObjectPool instance = freePool.poll();
        objectInUse.add(instance);
        return instance;
      }

      if (objectInUse.size() < DriverClass.SIZE) {
        TSObjectPool instance = new TSObjectPool();
        objectInUse.add(instance);
        return instance;
      }
    }

    throw new RuntimeException("Unable to get a object from Pool");

  }

  public void release() {
    synchronized (freePool) {
      objectInUse.remove(this);
      freePool.add(this);
      freePool.notify();
    }

  }

}

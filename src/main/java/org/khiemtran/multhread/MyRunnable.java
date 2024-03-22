package org.khiemtran.multhread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRunnable implements Runnable {
  private String name;

  public MyRunnable(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " Starting process " + name);
  }

  public static void main(String[] args) {
    String greeting = "Hello Thread";
    ExecutorService service = Executors.newFixedThreadPool(10);
    for (int i = 1; i <= 100; i++) {
      service.execute(new MyRunnable(greeting));
    }
    service.shutdown();
    while (!service.isTerminated()) {
    }
  }
}
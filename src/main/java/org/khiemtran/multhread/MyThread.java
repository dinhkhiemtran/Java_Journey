package org.khiemtran.multhread;

public class MyThread extends Thread {
  private int[] numbers;
  private int startIndex;
  private int endIndex;
  private int sum;

  public MyThread(int[] numbers, int startIndex, int endIndex) {
    this.numbers = numbers;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
  }

  @Override
  public void run() {
    for (int i = startIndex; i < endIndex; i++) {
      sum += numbers[i];
    }
  }

  public int getSum() {
    return sum;
  }

  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int numThreads = 5;
    MyThread[] threads = new MyThread[numThreads];
    int elementsPerThread = numbers.length / numThreads;
    for (int i = 0; i < numThreads; i++) {
      int startIndex = i * elementsPerThread;
      int endIndex = (i == numThreads - 1) ? numbers.length : (i + 1) * elementsPerThread;
      threads[i] = new MyThread(numbers, startIndex, endIndex);
      threads[i].start();
    }
    for (MyThread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    int totalSum = 0;
    for (MyThread thread : threads) {
      totalSum += thread.getSum();
    }
    System.out.println("sum: " + totalSum);
  }
}

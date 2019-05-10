package com.thread;


/**
 * @author yangyangl
 * @date 2019-02-11 11:32
 */
public class ThreadMain {
    public static void main(String[] args) {
     Runnable run = new MyThread();
     Thread thread = new Thread(run);
     Thread thread1 = new Thread(run);
     Thread thread2 = new Thread(run);
     Thread thread3 = new Thread(run);
     thread.start();
     thread1.start();
     thread2.start();
     thread3.start();
    }
}

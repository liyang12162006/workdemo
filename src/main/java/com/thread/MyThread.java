package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangyangl
 * @date 2019-02-11 11:30
 */
public class MyThread implements Runnable{
    private AtomicInteger count = new AtomicInteger(0);
    @Override
    public  void run() {
        System.out.println("这个是个线程！！！"+count.getAndIncrement());
    }
}

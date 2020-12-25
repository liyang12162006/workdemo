package com.example.ReentrantLockTest;

/**
 * @author liyangyang
 * @date 2020/12/22 14:37
 * @since 2.4.0.0
 */
public class ThreadA extends Thread {
    private Test test;
    public ThreadA(Test test) {
        super();
        this.test = test;
    }
    @Override
    public void run() {
        test.awaitA();
    }
}

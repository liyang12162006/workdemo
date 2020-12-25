package com.example.ReentrantLockTest;

/**
 * @author liyangyang
 * @date 2020/12/22 14:39
 * @since 2.4.0.0
 */
public class ThreadB extends Thread{

    private Test test;
    public ThreadB(Test test) {
        super();
        this.test = test;
    }
    @Override
    public void run() {
        test.awaitB();
    }
}

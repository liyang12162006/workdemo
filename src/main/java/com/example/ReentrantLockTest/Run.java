package com.example.ReentrantLockTest;

/**
 * @author liyangyang
 * @date 2020/12/22 14:38
 * @since 2.4.0.0
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        ThreadA a = new ThreadA(test);
        a.start();
        ThreadB b = new ThreadB(test);
        b.start();
        Thread.sleep(3000);
        test.signalA(); //唤醒A
    }


}

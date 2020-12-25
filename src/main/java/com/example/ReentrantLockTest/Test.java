package com.example.ReentrantLockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyangyang
 * @date 2020/12/22 14:36
 * @since 2.4.0.0
 */
public class Test {

    private Lock lock = new ReentrantLock();
    public Condition conditionB = lock.newCondition();
    public Condition conditionA = lock.newCondition();
    //等待
    public void awaitA() {
        lock.lock();    //调用lock.lock()方法的线程就持有了"对象监视器"，其他线程只有等待锁被释放时再次争抢
        try {
            System.out.println("awaitA()时间为：" + System.currentTimeMillis());
            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //等待
    public void awaitB() {
        lock.lock();    //调用lock.lock()方法的线程就持有了"对象监视器"，其他线程只有等待锁被释放时再次争抢
        try {
            System.out.println("awaitB()时间为：" + System.currentTimeMillis());
            conditionB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //通知
    public void signalA() {
        lock.lock();
        try {
            System.out.println("signalA()时间为：" + System.currentTimeMillis());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }
    //通知
    public void signalB() {
        lock.lock();
        try {
            System.out.println("signalB()时间为：" + System.currentTimeMillis());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }


}

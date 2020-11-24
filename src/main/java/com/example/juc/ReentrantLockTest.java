package com.example.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyangyang
 * @date 2020/11/20 15:38
 * @since 2.4.0.0
 */
public class ReentrantLockTest {

    //https://blog.csdn.net/weixin_38705074/article/details/106464202

    public static void main(String[] args) {
        ReentrantLockTest shareResource = new ReentrantLockTest();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.printC();
            }

        }, "c").start();

    }



    public void  testLock(){

        Lock lock = new ReentrantLock(false);

        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println("进来了当前线程是"+threadName);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println("进来了当前线程是"+threadName);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();

        new Thread(() -> {
            lock.lock();
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println("进来了当前线程是"+threadName);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "C").start();

    }



        private int num = 1;
        private Lock lock = new ReentrantLock();
        private Condition condition1 = lock.newCondition();
        private Condition condition2 = lock.newCondition();
        private Condition condition3 = lock.newCondition();

        public void printA() {
            lock.lock();
            try {
                while (num != 1) {
                    condition1.await();
                }
                num = 2;
                System.out.println(Thread.currentThread().getName());
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        public void printB() {
            lock.lock();
            try {
                while (num != 2) {
                    condition2.await();
                }
                num = 3;
                System.out.println(Thread.currentThread().getName());
                condition3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        public void printC() {
            lock.lock();
            try {
                while (num != 3) {
                    condition3.await();
                }
                num = 1;
                System.out.println(Thread.currentThread().getName());
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }


}

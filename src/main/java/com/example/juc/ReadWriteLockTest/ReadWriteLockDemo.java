package com.example.juc.ReadWriteLockTest;

/**
 * @author liyangyang
 * @date 2020/11/20 16:08
 * @since 2.4.0.0
 */
public class ReadWriteLockDemo {

    //https://blog.csdn.net/weixin_38705074/article/details/106469250
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        //5个线程写
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.write(String.valueOf(finalI), finalI+"111111");
            }, String.valueOf(i)).start();
        }

        //5个线程读
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.read(String.valueOf(finalI));
            }, String.valueOf(i)).start();
        }

        //5个线程读
        for (int i = 0; i < 5; i++) {
            int finalI = i;
        new Thread(()->{

        },"dasdsa ").start();

        }

    }

}

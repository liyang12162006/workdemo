package com.example.juc.ReadWriteLockTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liyangyang
 * @date 2020/11/20 16:08
 * @since 2.4.0.0
 */
public class MyCache {

    private volatile Map<String, Object> map = new HashMap();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void write(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始写入" + key+"----"+value);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "结束写入");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void read(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始读取");
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "结束读取" + value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}

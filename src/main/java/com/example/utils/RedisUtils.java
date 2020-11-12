package com.example.utils;

import java.util.concurrent.TimeUnit;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RAtomicDouble;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RBinaryStream;
import org.redisson.api.RBitSet;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RBoundedBlockingQueue;
import org.redisson.api.RBucket;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RDoubleAdder;
import org.redisson.api.RFuture;
import org.redisson.api.RLexSortedSet;
import org.redisson.api.RList;
import org.redisson.api.RListMultimap;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RPatternTopic;
import org.redisson.api.RPriorityBlockingDeque;
import org.redisson.api.RPriorityBlockingQueue;
import org.redisson.api.RPriorityDeque;
import org.redisson.api.RPriorityQueue;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RSemaphore;
import org.redisson.api.RSet;
import org.redisson.api.RSetCache;
import org.redisson.api.RSetMultimap;
import org.redisson.api.RSortedSet;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Redis Util
 *
 * @author zhaoke
 * @since 2019/12/18
 **/
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class RedisUtils {

    private static RedissonClient redissonClient;

    @Autowired
    public void setRedissonClient(RedissonClient redissonClient) {
        RedisUtils.redissonClient = redissonClient;
    }

    /**
     * 操作 {@link RBucket}
     *
     * @param name 键
     */
    public static RBucket<Object> getBucket(String name) {
        return redissonClient.getBucket(name);
    }

    /**
     * 操作 {@link RBucket}
     *
     * @param name      键
     * @param classType 数据类型
     */
    public static <T> RBucket<T> getBucket(String name, Class<T> classType) {
        return redissonClient.getBucket(name);
    }

    public static <T> void set(String name, T value) {
        RBucket<T> bucket = redissonClient.getBucket(name);
        bucket.set(value);
    }

    public static <T> void set(String name, T value, long expire) {
        set(name, value, expire, TimeUnit.MILLISECONDS);
    }

    /**
     * 设置缓存
     *
     * @param name     键
     * @param value    值
     * @param expire   过期时间
     * @param timeUnit 时间单位
     */
    public static <T> void set(String name, T value, long expire, TimeUnit timeUnit) {
        RBucket<T> bucket = redissonClient.getBucket(name);
        bucket.set(value, expire, timeUnit);
    }

    /**
     * 设置缓存
     *
     * @param name  键
     * @param value 值
     */
    public static <T> RFuture<Void> setAsync(String name, T value) {
        RBucket<T> bucket = redissonClient.getBucket(name);
        return bucket.setAsync(value);
    }

    /**
     * 设置缓存
     *
     * @param name   键
     * @param value  值
     * @param expire 过期时间(默认单位：毫秒)
     */
    public static <T> RFuture<Void> setAsync(String name, T value, long expire) {
        return setAsync(name, value, expire, TimeUnit.MILLISECONDS);
    }

    /**
     * 异步设置缓存
     *
     * @param name     键
     * @param value    值
     * @param expire   过期时间
     * @param timeUnit 时间单位
     */
    public static <T> RFuture<Void> setAsync(String name, T value, long expire, TimeUnit timeUnit) {
        RBucket<T> bucket = redissonClient.getBucket(name);
        return bucket.setAsync(value, expire, timeUnit);
    }

    /**
     * 查询
     *
     * @param name 键
     */
    public static <T> T get(String name) {
        return get(name, null);
    }

    /**
     * 查询
     *
     * @param name      键
     * @param classType 返回数据类型
     */
    public static <T> T get(String name, Class<T> classType) {
        RBucket<T> bucket = redissonClient.getBucket(name);
        return bucket.get();
    }

    /**
     * 异步查询
     *
     * @param name 键
     */
    public static <T> RFuture<T> getAsync(String name) {
        return getAsync(name, null);
    }

    /**
     * 异步查询
     *
     * @param name 键
     */
    public static <T> RFuture<T> getAsync(String name, Class<T> classType) {
        RBucket<T> bucket = redissonClient.getBucket(name);
        return bucket.getAsync();
    }

    /**
     * 查询并删除
     *
     * @param name 键
     */
    public static <T> T getAndDelete(String name) {
        return getAndDelete(name, null);
    }

    /**
     * 查询并删除
     *
     * @param name      键
     * @param classType 返回数据类型
     */
    public static <T> T getAndDelete(String name, Class<T> classType) {
        RBucket<T> bucket = redissonClient.getBucket(name);
        return bucket.getAndDelete();
    }

    /**
     * 异步查询并删除
     *
     * @param name 键
     */
    public static <T> RFuture<T> getAndDeleteAsync(String name) {
        return getAndDeleteAsync(name, null);
    }

    /**
     * 异步查询并删除
     *
     * @param name      键
     * @param classType 返回数据类型
     */
    public static <T> RFuture<T> getAndDeleteAsync(String name, Class<T> classType) {
        RBucket<T> bucket = redissonClient.getBucket(name);
        return bucket.getAndDeleteAsync();
    }

    /**
     * 查询并重新赋值
     *
     * @param name     键
     * @param newValue 新值
     */
    public static <T> T getAndSet(String name, T newValue) {
        RBucket<T> bucket = redissonClient.getBucket(name);
        return bucket.getAndSet(newValue);
    }

    /**
     * 查询并重新赋值
     *
     * @param name     键
     * @param newValue 新值
     * @param expire   过期时间(默认单位：毫秒)
     */
    public static <T> T getAndSet(String name, T newValue, long expire) {
        return getAndSet(name, newValue, expire, TimeUnit.MILLISECONDS);
    }

    /**
     * 查询并重新赋值
     *
     * @param name     键
     * @param newValue 新值
     * @param expire   过期时间
     * @param timeUnit 时间单位
     */
    public static <T> T getAndSet(String name, T newValue, long expire, TimeUnit timeUnit) {
        RBucket<T> bucket = redissonClient.getBucket(name);
        return bucket.getAndSet(newValue, expire, timeUnit);
    }

    /**
     * 操作 {@link RList}
     *
     * @param name 键
     */
    public static RList<Object> getList(String name) {
        return redissonClient.getList(name);
    }

    /**
     * 操作 {@link RList}
     *
     * @param name      键
     * @param classType 数据类型
     */
    public static <V> RList<V> getList(String name, Class<V> classType) {
        return redissonClient.getList(name);
    }

    /**
     * 操作 {@link RSet}
     *
     * @param name 键
     */
    public static RSet<Object> getSet(String name) {
        return redissonClient.getSet(name);
    }

    /**
     * 操作 {@link RSet}
     *
     * @param name      键
     * @param classType 数据类型
     */
    public static <V> RSet<V> getSet(String name, Class<V> classType) {
        return redissonClient.getSet(name);
    }

    /**
     * 操作 {@link RAtomicLong}
     *
     * @param name 键
     */
    public static RAtomicLong getAtomicLong(String name) {
        return redissonClient.getAtomicLong(name);
    }

    /**
     * 操作 {@link RAtomicLong}
     *
     * @param name 键
     */
    public static RAtomicDouble getAtomicDouble(String name) {
        return redissonClient.getAtomicDouble(name);
    }

    /**
     * 操作 {@link RBinaryStream}
     *
     * @param name 键
     */
    public static RBinaryStream getBinaryStream(String name) {
        return redissonClient.getBinaryStream(name);
    }

    /**
     * 操作 {@link RBitSet}
     *
     * @param name 键
     */
    public static RBitSet getBitSet(String name) {
        return redissonClient.getBitSet(name);
    }

    /**
     * 操作 {@link RBlockingQueue}
     *
     * @param name 键
     */
    public static <V> RBlockingQueue<V> getBlockingQueue(String name) {
        return redissonClient.getBlockingQueue(name);
    }

    /**
     * 操作 {@link RBlockingDeque}
     *
     * @param name 键
     */
    public static <V> RBlockingDeque<V> getBlockingDeque(String name) {
        return redissonClient.getBlockingDeque(name);
    }

    /**
     * 操作 {@link RPriorityBlockingQueue}
     *
     * @param name 键
     */
    public static <V> RPriorityBlockingQueue<V> getPriorityBlockingQueue(String name) {
        return redissonClient.getPriorityBlockingQueue(name);
    }

    /**
     * 操作 {@link RPriorityBlockingDeque}
     *
     * @param name 键
     */
    public static <V> RPriorityBlockingDeque<V> getPriorityBlockingDeque(String name) {
        return redissonClient.getPriorityBlockingDeque(name);
    }

    /**
     * 操作 {@link RPriorityQueue}
     *
     * @param name 键
     */
    public static <V> RPriorityQueue<V> getPriorityQueue(String name) {
        return redissonClient.getPriorityQueue(name);
    }

    /**
     * 操作 {@link RPriorityDeque}
     *
     * @param name 键
     */
    public static <V> RPriorityDeque<V> getPriorityDeque(String name) {
        return redissonClient.getPriorityDeque(name);
    }

    /**
     * 操作 {@link RBloomFilter}
     *
     * @param name 键
     */
    public static <T> RBloomFilter<T> getBloomFilter(String name) {
        return redissonClient.getBloomFilter(name);
    }

    /**
     * 操作 {@link RBoundedBlockingQueue}
     *
     * @param name 键
     */
    public static <V> RBoundedBlockingQueue<V> getBoundedBlockingQueue(String name) {
        return redissonClient.getBoundedBlockingQueue(name);
    }

    /**
     * 操作 {@link RCountDownLatch}
     *
     * @param name 键
     */
    public static RCountDownLatch getCountDownLatch(String name) {
        return redissonClient.getCountDownLatch(name);
    }

    /**
     * 操作 {@link RDoubleAdder}
     *
     * @param name 键
     */
    public static RDoubleAdder getDoubleAdder(String name) {
        return redissonClient.getDoubleAdder(name);
    }

    /**
     * 操作 {@link RTopic}
     *
     * @param name 键
     */
    public static RTopic getTopic(String name) {
        return redissonClient.getTopic(name);
    }

    /**
     * 操作 {@link RPatternTopic}
     *
     * @param name 键
     */
    public static RPatternTopic getPatternTopic(String name) {
        return redissonClient.getPatternTopic(name);
    }

    /**
     * 操作 {@link RSortedSet}
     *
     * @param name 键
     */
    public static <V> RSortedSet<V> getSortedSet(String name) {
        return redissonClient.getSortedSet(name);
    }

    /**
     * 操作 {@link RScoredSortedSet}
     *
     * @param name 键
     */
    public static <V> RScoredSortedSet<V> getScoredSortedSet(String name) {
        return redissonClient.getScoredSortedSet(name);
    }

    /**
     * 操作 {@link RLexSortedSet}
     *
     * @param name 键
     */
    public static RLexSortedSet getLexSortedSet(String name) {
        return redissonClient.getLexSortedSet(name);
    }

    /**
     * 操作 {@link RSemaphore}
     *
     * @param name 键
     */
    public static RSemaphore getSemaphore(String name) {
        return redissonClient.getSemaphore(name);
    }

    /**
     * 操作 {@link RSetCache}
     *
     * @param name 键
     */
    public static <V> RSetCache<V> getSetCache(String name) {
        return redissonClient.getSetCache(name);
    }

    /**
     * 操作 {@link RRateLimiter}
     *
     * @param name 键
     */
    public static RRateLimiter getRRateLimiter(String name) {
        return redissonClient.getRateLimiter(name);
    }

    /**
     * 操作 {@link RReadWriteLock}
     *
     * @param name 键
     */
    public static RReadWriteLock getReadWriteLock(String name) {
        return redissonClient.getReadWriteLock(name);
    }

    /**
     * 操作 {@link RLock}
     *
     * @param name 键
     */
    public static RLock getFairLock(String name) {
        return redissonClient.getFairLock(name);
    }

    /**
     * 操作 {@link RLock}
     *
     * @param name 键
     */
    public static RLock getLock(String name) {
        return redissonClient.getLock(name);
    }

    /**
     * 操作 {@link RMap}
     *
     * @param name 键
     */
    public static <K, V> RMap<K, V> getMap(String name) {
        return redissonClient.getMap(name);
    }

    /**
     * 操作 {@link RSetMultimap}
     *
     * @param name 键
     */
    public static <K, V> RSetMultimap<K, V> getSetMultimap(String name) {
        return redissonClient.getSetMultimap(name);
    }

    /**
     * 操作 {@link RListMultimap}
     *
     * @param name 键
     */
    public static <K, V> RListMultimap<K, V> getListMultimap(String name) {
        return redissonClient.getListMultimap(name);
    }
}

package com.example.utils;

import com.huitongjy.common.generator.BatchKey;
import com.huitongjy.common.generator.ExtraKeyGenerator;
import com.huitongjy.common.generator.IKeyGenerator;
import com.huitongjy.common.generator.SimpleKeyGenerator;
import com.huitongjy.common.zookeeper.ZooKeeperWorkId;

/**
 * 考试系统 主键Id生成器
 * Bean初始化前需要先初始化ZooKeeperWorkId
 */
public class ExamKeyGenerator implements IKeyGenerator {
    /**
     * 机器Id 位
     */
    private static final int WORKER_ID_BITS = 9;
    /**
     * 自增索引 位
     */
    private static final int SEQUENCE_BITS = 12;

    /**
     * 时间戳偏移
     */
    private static final int TIMES_LEFT_BITS = WORKER_ID_BITS + SEQUENCE_BITS;

    /**
     * 时间戳的最大值
     */
    private static final long TIMES_MAX_VALUE = (1L << 41) - 1;

    /**
     * 通用ID生成器
     */
    private IKeyGenerator keyGenerator;


    public ExamKeyGenerator() {
        keyGenerator = new ExtraKeyGenerator(WORKER_ID_BITS, SEQUENCE_BITS, ZooKeeperWorkId.getInstanse().getWorkerId(), 1L);
    }

    @Override
    public Long generateKey() {
        return keyGenerator.generateKey();
    }

    @Override
    public BatchKey generateKey(int num) {
        return keyGenerator.generateKey(num);
    }

    /**
     * 获取Id的时间戳
     */
    public static Long getTimestamp(Long key) {
        return ((key >> TIMES_LEFT_BITS) & TIMES_MAX_VALUE) + SimpleKeyGenerator.EPOCH;
    }

}

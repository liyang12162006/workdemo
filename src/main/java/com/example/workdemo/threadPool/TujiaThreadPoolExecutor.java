package com.example.workdemo.threadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yaohuaz@tujia.com
 * 2017/12/11 下午10:20
 * 定制线程池,可以进行通过设置剩余阻塞队列可用容量值来通过报警系统预警
 */
public class TujiaThreadPoolExecutor {

    private Logger logger = LoggerFactory.getLogger(TujiaThreadPoolExecutor.class);

    private String executorName = "TUJIA线程池执行器";
    /**
     * 默认与CPU核心数数一致
     */
    private int corePoolSize = 4;
    /**
     * 核心线程数和最大线程数建议保持一致以保证执行顺序
     * 不同应用场景(IO\CPU)需采取不同线程策略
     */
    private int maximumPoolSize = 4;

    private long keepAliveTime = 10L;

    private int queueCapacity = 2048;
    /**
     * //默认使用一半时即报警
     */
    private int alarmWhenRemains = 1024;
    /**
     * 剩余线程数报警阈值
     */
    private int alarmWhenThreadsRemains = 2;

    private Thread monitorThread;

    private String monitorPrefix = "tujia";
    /**
     * 线程池执行器是否被销毁的标志
     */
    private AtomicBoolean isOpen = new AtomicBoolean(false);
    /**
     * 监控每10秒输出队列日志
     */
    private final long monitorRefreshInterval = 10000L;
    /**
     * 是否打印队列信息log
     */
    private boolean logPrint = false;

    public TujiaThreadPoolExecutor() {
    }

    /**
     * 使用默认参数构造线程池
     *
     * @param executorName
     * @param monitorPrefix
     */
    public TujiaThreadPoolExecutor(String executorName, String monitorPrefix) {
        this.executorName = executorName;
        this.monitorPrefix = monitorPrefix;
    }

    /**
     * 定制线程池构造方法
     *
     * @param executorName    执行器名称
     * @param corePoolSize    核心线程数
     * @param maximumPoolSize 最大线程数, 核心线程数和最大线程数建议保持一致以保证执行顺序(不同应用场景(IO\CPU)需采取不同线程策略)
     * @param keepAliveTime   最大空闲时间, 单位:TimeUnit.SECONDS
     * @param queueCapacity   阻塞队列容量
     * @param logPrint        是否打印阻塞队列容量信息
     */
    public TujiaThreadPoolExecutor(String executorName, String monitorPrefix, int corePoolSize, int maximumPoolSize
            , long keepAliveTime, int queueCapacity, int alarmWhenRemains, int alarmWhenThreadsRemains, boolean logPrint) {
        this.executorName = executorName;
        this.monitorPrefix = monitorPrefix;
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.queueCapacity = queueCapacity;
        this.alarmWhenRemains = alarmWhenRemains;
        this.alarmWhenThreadsRemains = alarmWhenThreadsRemains;
        this.logPrint = logPrint;
    }

    private ThreadPoolExecutor pool = null;

    public void init() {
        pool = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(queueCapacity),
                new TujiaThreadFactory(),
                new TujiaRejectedExecutionHandler());
        isOpen.set(true);
        monitorThread = pool.getThreadFactory().newThread(() -> {
            while (isOpen.get()) {
                int queueRemains = queueCapacity - pool.getQueue().size();
                int threadsRemains = maximumPoolSize - pool.getPoolSize();
                if (logPrint) {
                    logger.info("线程执行器[{}]监控线程输出:队列总容量{},剩余:{}, 线程总容量{},剩余:{}", executorName
                            , queueCapacity, queueRemains, maximumPoolSize, threadsRemains);
                }
                if (queueRemains < alarmWhenRemains) {
                    logger.warn("线程执行器[{}]监控线程输出:剩余容量已达到预警值! 预警值:{},总容量{},剩余:{}", executorName
                            , alarmWhenRemains, queueCapacity, queueRemains);
                    //记录超出预警阈值的值作为监控值
                }
                if (threadsRemains < alarmWhenThreadsRemains) {
                    logger.warn("线程执行器[{}]监控线程输出:剩余线程数已达到预警值! 预警值:{},总容量{},剩余:{}", executorName
                            , alarmWhenThreadsRemains, maximumPoolSize, threadsRemains);
                    //记录超出预警阈值的值作为监控值
                }
                try {
                    Thread.sleep(monitorRefreshInterval);
                } catch (InterruptedException e) {
                    logger.error("线程执行器[{}]监控线程输出:线程中断异常", executorName, e);
                    Thread.currentThread().interrupt();
                }
            }

            logger.info("线程执行器[{}]监控线程输出:监控线程销毁完毕", executorName);
        });
        monitorThread.start();
    }


    public void destroy() {
        logger.info("线程执行器[{}]执行销毁", executorName);
        isOpen.set(false);
        if (pool != null) {
            pool.shutdownNow();
        }
        logger.info("线程执行器[{}]销毁完毕", executorName);
    }


    public ExecutorService getTujiaThreadPoolExecutor() {
        return this.pool;
    }

    private class TujiaThreadFactory implements ThreadFactory {

        private AtomicLong count = new AtomicLong(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = TujiaThreadPoolExecutor.class.getSimpleName() + count.addAndGet(1);
            logger.info("线程池执行器[{}] 新建线程:{}", executorName, threadName);
            t.setName(threadName);
            return t;
        }
    }

    private class TujiaRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            logger.error("线程池执行器[{}]的队列已满,拒绝任务", executorName);
        }
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getAlarmWhenRemains() {
        return alarmWhenRemains;
    }

    public void setAlarmWhenRemains(int alarmWhenRemains) {
        this.alarmWhenRemains = alarmWhenRemains;
    }

    public int getAlarmWhenThreadsRemains() {
        return alarmWhenThreadsRemains;
    }

    public void setAlarmWhenThreadsRemains(int alarmWhenThreadsRemains) {
        this.alarmWhenThreadsRemains = alarmWhenThreadsRemains;
    }

    public String getMonitorPrefix() {
        return monitorPrefix;
    }

    public void setMonitorPrefix(String monitorPrefix) {
        this.monitorPrefix = monitorPrefix;
    }

    public boolean isLogPrint() {
        return logPrint;
    }

    public void setLogPrint(boolean logPrint) {
        this.logPrint = logPrint;
    }
}

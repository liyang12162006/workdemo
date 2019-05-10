package com.thread;

/**
 * @author yangyangl
 * @date 2019-02-12 9:56
 */
public class TestThreadLocal {
    private boolean wxnostop;

    private static ThreadLocal threadLocal = new ThreadLocal() {
        @Override
        protected TestThreadLocal initialValue() {
            return null;
        }
    };

    public TestThreadLocal() {
    }

    public static TestThreadLocal getThreadLocal() {
        return (TestThreadLocal) threadLocal.get();
    }

    public static void setThreadLocal(TestThreadLocal context) {
        threadLocal.set(context);
    }

    public boolean isWxnostop() {
        return wxnostop;
    }

    public void setWxnostop(boolean wxnostop) {
        this.wxnostop = wxnostop;
    }

    public static void removeThreadLocal() {
        threadLocal.remove();
    }
}

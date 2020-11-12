package com.example.degsinMode.singleton;

/**
 * @author yangyangl
 * @date 2019-01-31 15:17
 */
public class singleton_inner {
        /**
         * 内部类实现单例模式
         * 延迟加载，减少内存开销
         */
        private static class SingletonHolder {
            private static singleton_inner instance = new singleton_inner();
        }

        /**
         * 私有的构造函数
         */
        private singleton_inner() {}

        public static singleton_inner getInstance() {
            return SingletonHolder.instance;
        }

        protected void method() {
            System.out.println("SingletonInner");
        }
    }



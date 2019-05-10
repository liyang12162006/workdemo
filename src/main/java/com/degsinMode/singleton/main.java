package com.degsinMode.singleton;

/**
 * @author yangyangl
 * @date 2019-01-31 15:11
 */
public class main {
    public static void main(String[] args) {
        singleton_lazy.getInstance().method();
        Singleton_hunger.getInstance().method();
        singleton_inner.getInstance().method();
    }
}

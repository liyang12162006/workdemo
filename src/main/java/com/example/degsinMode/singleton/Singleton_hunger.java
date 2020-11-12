package com.example.degsinMode.singleton;

/**
 * @author yangyangl
 * @date 2019-01-31 15:01
 */
public class Singleton_hunger {
    private static final Singleton_hunger instance = new Singleton_hunger();

    private Singleton_hunger(){}

    public static Singleton_hunger getInstance(){
            return instance;
    }
    protected  void method(){
        System.out.println("1232432233");
    }

}

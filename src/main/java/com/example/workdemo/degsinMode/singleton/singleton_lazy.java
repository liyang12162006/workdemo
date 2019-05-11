package com.example.workdemo.degsinMode.singleton;

/**
 * @author yangyangl
 * @date 2019-01-31 15:04
 */
public class singleton_lazy {
    private volatile  static singleton_lazy instance = null ;

    private singleton_lazy(){}

    public static singleton_lazy getInstance(){

        if (instance == null){
            synchronized (singleton_lazy.class){
                if (instance == null ){
                    instance = new singleton_lazy();
                }
            }
        }
        return instance;
    }

    protected  void method(){
        System.out.println("12313");
    }

}

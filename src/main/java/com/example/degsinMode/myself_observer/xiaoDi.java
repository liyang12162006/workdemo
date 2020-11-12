package com.example.degsinMode.myself_observer;

/**
 * @author yangyangl
 * @date 2019-01-31 11:44
 */
public class xiaoDi implements guanChazhe {
    private String name;
    private String message;


    public xiaoDi(String name) {
        this.name = name;
    }

    @Override
    public void doSomeThing(String s) {
       this.message = s;
       daren(s);
    }

    public void daren(String s){
        System.out.println("我收到"+s+"我这就去找他！！！");
    }
}

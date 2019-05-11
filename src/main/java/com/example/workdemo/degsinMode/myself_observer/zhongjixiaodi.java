package com.example.workdemo.degsinMode.myself_observer;

/**
 * @author yangyangl
 * @date 2019-01-31 13:06
 */
public class zhongjixiaodi implements guanChazhe{
    private String name;
    private String message;

    public zhongjixiaodi(String name) {
        this.name = name;
    }

    @Override
    public void doSomeThing(String s) {
        this.message = s;
        read(s);

    }


    public void read(String s){
        System.out.println("我认识他。"+s+"  马上去收拾他       飒飒");
    }
}

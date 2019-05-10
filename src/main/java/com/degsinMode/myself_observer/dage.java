package com.degsinMode.myself_observer;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yangyangl
 * @date 2019-01-31 11:46
 */
public class dage implements beiGuanChaZhe {

    private List<guanChazhe> list;
    private String message;

    public dage() {
        list = new ArrayList<guanChazhe>();
    }

    @Override
    public void registerObserver(guanChazhe guanChazhe) {
            list.add(guanChazhe);
    }

    @Override
    public void removeObserver(guanChazhe guanChazhe) {
        if (!list.isEmpty()){
            list.remove(guanChazhe);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < list.size(); i++) {
            guanChazhe guanChazhe = list.get(i);
            guanChazhe.doSomeThing(message);
        }
    }
    public void sethuodong(String s){
       this.message =s;
        System.out.println("--命令是-"+s);
        notifyObserver();
    }
}

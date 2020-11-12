package com.example.degsinMode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangyangl
 * @date 2019-01-17 20:58
 */
public class WechatServer implements doObserver {

    // 注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<observer>();
    }

    @Override
    public void registerObserver(observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(observer o) {
        if (!list.isEmpty()){
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < list.size(); i++) {
            observer oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        // 消息更新，通知所有观察者
        notifyObserver();
    }
}

package com.degsinMode.observer;

/**
 * @author yangyangl
 * @date 2019-01-17 21:05
 */
public class domain {
    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        observer userZhang = new User("ZhangSan");
        observer userLi = new User("LiSi");
        observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");
    }
}

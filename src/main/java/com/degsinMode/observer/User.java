package com.degsinMode.observer;

/**
 * @author yangyangl
 * @date 2019-01-17 21:03
 */
public class User implements observer {
    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read(message);
    }

    private void read(String message) {
        System.out.println("收到" + message);
    }
}

package com.example.workdemo.degsinMode.myself_observer;

/**
 * @author yangyangl
 * @date 2019-01-31 11:43
 */
public interface beiGuanChaZhe {
    public void registerObserver(guanChazhe guanChazhe);

    public void removeObserver(guanChazhe guanChazhe);

    public void notifyObserver();
}

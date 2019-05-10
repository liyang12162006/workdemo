package com.degsinMode.observer;

/**
 * @author yangyangl
 * @date 2019-01-17 20:55
 */
public interface doObserver {
    public void registerObserver(observer o);

    public void removeObserver(observer o);

    public void notifyObserver();
}

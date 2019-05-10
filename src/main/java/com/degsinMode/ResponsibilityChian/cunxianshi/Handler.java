package com.degsinMode.ResponsibilityChian.cunxianshi;

/**
 * @author yangyangl
 * @date 2019-01-31 14:11
 */
public abstract class Handler {

    protected Handler next;

    public abstract void handleRequest(String value);


    public Handler next() {
        return this.next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
}

package com.degsinMode.ResponsibilityChian.cunxianshi;

/**
 * @author yangyangl
 * @date 2019-01-31 14:18
 */
public class CountyHandler extends Handler {

    @Override
    public void handleRequest(String value) {
        if ("county".equals(value)) {
            System.out.println("County: handled~-----省级处理了");
        } else if (this.next == null) {
            System.out.println("no next Handler, this request can not be handle~   省级没处理  也有下一级 直接去中央吧");
        } else {
            System.out.println("County: pass~   省级处理不了 放过了");
            this.next.handleRequest(value);
        }
    }
}

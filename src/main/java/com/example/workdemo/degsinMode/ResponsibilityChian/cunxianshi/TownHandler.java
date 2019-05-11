package com.example.workdemo.degsinMode.ResponsibilityChian.cunxianshi;

/**
 * @author yangyangl
 * @date 2019-01-31 14:18
 */
public class TownHandler extends Handler {

    @Override
    public void handleRequest(String value) {
        if ("town".equals(value)) {
            System.out.println("VillageHandler: handled~ ----县级处理了");
        } else {
            System.out.println("Town: pass~ ----县级处理不了 放过了");
            this.next.handleRequest(value);
        }
    }
}
package com.degsinMode.ResponsibilityChian.cunxianshi;

/**
 * @author yangyangl
 * @date 2019-01-31 14:16
 */
public class VillageHandler extends Handler {

    @Override
    public void handleRequest(String value) {
        if ("village".equals(value)) {
            System.out.println("VillageHandler: handled~---村级处理了");
        } else {
            System.out.println("VillageHandler: pass~   村级处理不了 放过了");
            this.next.handleRequest(value);
        }
    }

}

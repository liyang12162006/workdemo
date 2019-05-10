package com.mobileEncode;

/**
 * @author yangyangl
 * @date 2018-11-01 15:04
 */
public class mobileEncode {
    public static void main(String[] args) {
        String mobile = "13521292983";
        mobile = mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(mobile);
    }
}

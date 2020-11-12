package com.example.example;

/**
 * @author yangyangl
 * @date 2018-09-03 17:00
 */
public enum orderStatus {
    ORDER_1(1,"O1","已预订"),
    ORDER_2(2,"O2","预订中"),
    ORDER_3(3,"O3","待支付"),
    ORDER_4(4,"O4","已支付"),
    ORDER_5(5,"O5","已派送");

    private String desc;
    private int code;
    private String method;


    orderStatus(int code, String method, String desc) {
        this.code = code;
        this.method = method;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getMethod() {
        return method;
    }

    public static void main(String[] args) {
        System.out.println(orderStatus.ORDER_1);
        System.out.println(orderStatus.ORDER_1.name());
        System.out.println(orderStatus.ORDER_1.getCode());
        System.out.println(orderStatus.ORDER_1.getDesc());
        System.out.println(orderStatus.ORDER_1.code);
        System.out.println(orderStatus.ORDER_1.desc);
        System.out.println(orderStatus.ORDER_1.getMethod());
    }
}

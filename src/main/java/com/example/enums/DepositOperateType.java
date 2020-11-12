package com.example.enums;

import java.util.Arrays;

/**
 * 押金操作类型
 *
 * @author guoming.ren [guomingr@tujia.com]
 *         11/22/2017 6:56 PM
 */
public enum DepositOperateType {

    SYSTEM_INIT_CANCEL(1, "订单取消时的押金状态初始化"),
    SYSTEM_INIT_CHECKOUT(2, "订单离店时的押金状态初始化"),
    MERCHANT_RETURN_DEPOSIT(3, "商户退还押金"),
    MERCHANT_DEDUCT_DEPOSIT(4, "商户申请扣除押金"),
    MERCHANT_DEAL_EXPIRED(5, "商户处理超时"),
    MERCHANT_APPLY_ARBITRATION(6, "商户申请仲裁"),
    CUSTOMER_REJECT(7, "用户拒绝"),
    CUSTOMER_APPROVAL(8, "用户同意"),
    CUSTOMER_REPLY_EXPIRED(9, "用户回复超时"),
    AGENT_ARBITRATE(10, "坐席仲裁"),
    SYSTEM_APPLY_ARBITRATION(11, "系统发起押金申请仲裁");

    private int code;
    private String description;

    DepositOperateType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public static DepositOperateType codeOf(int code) {
        return Arrays.stream(DepositOperateType.values()).filter(a -> a.getCode() == code).findFirst().orElse(null);
    }
}

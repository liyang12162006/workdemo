package com.example.workdemo.threadPool.HtYeXiangYangDemo;

import org.apache.commons.lang3.EnumUtils;

/**
 * @author : liyangyang
 * @date 2019-05-13 20:02
 */
public enum SubjectEnum implements IEnum<Integer> {
    UNKNOWN(0, "所有"), //默认值
    CHINESE(1, "语文"),
    MATHEMATICS(2, "数学"),
    ENGLISH(3, "英语"),
    PHYSICS(4, "物理"),
    CHEMISTRY(5, "化学"),
    BIOLOGY(6, "生物"),
    HISTORY(7, "历史"),
    GEOGRAPHY(8, "地理"),
    POLITICS(9, "政治"),
    OTHER(10,"其他"),
    GENERIC_TECHNOLOGY(11,"通用技术"),
    INFORMATION_TECHNOLOGY(12,"信息技术");

    private int value;
    private String title;

//    public static SubjectEnum create(Integer value) {
//        return EnumUtils.getEnum(SubjectEnum.values(), value);
//    }
//
//    public static SubjectEnum createFromTitle(String title) {
//        return EnumUtils.getEnumFromTitle(SubjectEnum.values(), title);
//    }

    SubjectEnum(int value, String title) {
        this.value = value;
        this.title = title;
    }

    /*@JsonCreator
    public static  SubjectEnum forValue(String title) {
        SubjectEnum e = EnumUtils.getEnumFromTitle(SubjectEnum.values(), title);
        return e;
    }*/

    @Override
    public Integer getValue() {
        return value;
    }
    @Override
    public String getTitle() {
        return title;
    }
//
//    public String toString() {
//        return EnumUtils.toJSONString(this);
//    }
}

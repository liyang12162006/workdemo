package com.example.workdemo.threadPool.HtYeXiangYangDemo;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author : liyangyang
 * @date 2019-05-13 19:58
 */
public enum EducationStageEnum implements IEnum<Integer> {

    //未区分-不区分初高中, 并非初中和高中的合集
    DEFAULT(0, "未区分"),
    HIGH(1, "高中"),
    MIDDLE(2, "初中");

    private int value;
    private String title;

//    public static EducationStageEnum create(Integer value) {
//       // return (EducationStageEnum) EnumUtils.getEnum(values(), value);
//    }

    EducationStageEnum(int value, String title) {
        this.value = value;
        this.title = title;
    }

//    public static List<EducationStageEnum> convert(List<Integer> codeList) {
//        List<EducationStageEnum> targetList = new ArrayList<>();
//        if (CollectionUtils.isNotEmpty(codeList)) {
//            for (Integer code : codeList) {
//                targetList.add(create(code));
//            }
//        }
//        return targetList;
//    }

    @Override
    public Integer getValue() {
        return Integer.valueOf(this.value);
    }

    @Override
    public String getTitle() {
        return this.title;
    }

}


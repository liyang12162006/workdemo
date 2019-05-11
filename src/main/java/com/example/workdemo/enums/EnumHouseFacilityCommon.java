package com.example.workdemo.enums;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Set;

/**
 * @author yaohuaz@tujia.com
 *         2018/12/24 6:05 PM
 * 订单上常用的基础设施
 * //@see com.tujia.tns.baseinfo.api.vo.house.CheckinInstructions#enumHouseFacilities
 */
public enum EnumHouseFacilityCommon {

    WIFI(1, "无线网络"),
    BROADBAND(2, "有线网络"),
    WINDOW(47, "有窗");


    EnumHouseFacilityCommon(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;

    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static boolean belongsToCommonFac(int code) {
        for (EnumHouseFacilityCommon enumHouseFacilityCommon : EnumHouseFacilityCommon.values()) {
            if (code == enumHouseFacilityCommon.code) {
                return true;
            }
        }
        return false;
    }


    private static Set<Integer> EnumHouseFacilityCommonSet = Sets.newHashSet();
    static {
        EnumHouseFacilityCommonSet.add(EnumHouseFacilityCommon.BROADBAND.getCode());
        EnumHouseFacilityCommonSet.add(EnumHouseFacilityCommon.WIFI.getCode());
        EnumHouseFacilityCommonSet.add(EnumHouseFacilityCommon.WINDOW.getCode());
    }

    public static boolean isExist(int key) {
        return EnumHouseFacilityCommonSet.contains(key);
    }

    public static EnumHouseFacilityCommon codeOf(int code){
        EnumHouseFacilityCommon enumHouseFacilityCommon = Arrays.stream(EnumHouseFacilityCommon.values()).filter(s->s.getCode() == code).findFirst().orElse(null);
        return enumHouseFacilityCommon;
    }

}

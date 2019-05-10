package com.enums;

/**
 * @author yangyangl
 * @date 2018-10-25 14:34
 */
public enum APISellChannelType implements BaseEnum {
    None(0, ""),

    TmallAlipay(1, "天猫公寓"),

    TmallAlipayVac(2, "天猫度假"),

    TmallCredit(3, "天猫信用住"),

    MeiTuan(4, "美团"),

    Qunar(5, "去哪儿"),

    CtripInn(6, "携程民宿"),

    TongCheng(7, "同程"),

    ShanHaiBian(8, "山海边"),

    ChinaUnitedAirlines(10, "中国联航"),

    JointWisdom(11, "众荟"),

    MaYi(12, "蚂蚁短租"),

    TmallPromotion(13, "天猫大促"),

    MeiTuanSelfSupport(14, "美团自营"),

    XiHe(15, "羲和"),

    CtripHotel(18, "携程酒店"),

    CtripOld(19, "携程民宿老"),

    CtripHotelOld(20, "携程酒店老"),

    LaiShou(21, "拉手网"),

    Elong(22, "艺龙网"),

    TmallMerchant(26, "天猫商户"),

    XiWan(27, "喜玩"),

    DaYue(28, "大粤"),

    BetaTest(29, "Beta测试"),

    FeizhuMerchant(30, "飞猪商户店"),

    QunarHotel(41, "去哪儿酒店"),

    QunarInn(42, "去哪儿民宿"),

    MayiNew(43, "新蚂蚁"),

    FeizhuBnb(44, "飞猪民宿专营店"),

    ElongHotel(45, "艺龙酒店"), Vjmobi(46, "微匠"), Qmango(47, "青芒果"), Etrip(48, "易商旅");

    private int code;

    private String desc;

    APISellChannelType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

//    public static com.tujia.tns.hds.api.bean.enums.APISellChannelType codeOf(int code) {
//        for (com.tujia.tns.hds.api.bean.enums.APISellChannelType item : com.tujia.tns.hds.api.bean.enums.APISellChannelType
//                .values()) {
//            if (item.getCode() == code) {
//                return item;
//            }
//        }
//        return null;
//    }
}

package com.utils.dateutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wenyueq on 2018/5/10
 */
public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    /**
     * 通过时间毫秒数判断两个时间的相差天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    /**
     * 计算两个日期之间的天数
     *
     * @param firstDate
     * @param secondDate
     * @return
     */
//    public static long diffDayByYMD(Date firstDate, Date secondDate) {
//        firstDate = ShortDate.valueOf(firstDate).toDate();
//        secondDate = ShortDate.valueOf(secondDate).toDate();
//
//        long diff = firstDate.getTime() - secondDate.getTime();
//        long days = diff / (1000 * 60 * 60 * 24);
//        if (days < 0) {
//            days = 0 - days;
//        }
//        return days;
//    }

    /**
     * 字符串转换为年月日
     * @param s
     * @return
     */
    public static Date string2Date(String s) throws Exception {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
        } catch (ParseException e) {
            logger.error("日期格式错误{}", s, e);
            throw new Exception("阳关车导相关日期格式转换错误......");
        }
        return date;
    }
    /**
     * 字符串转换时间  用于转换阳关车导对应返回时间
     * @param s
     * @return
     */
    public static Date stringYGCDate(String s) throws Exception {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(s);
        } catch (ParseException e) {
            logger.error("日期格式错误{}", s, e);
            throw new Exception("阳关车导相关日期格式转换错误......");
        }
        return date;
    }

    /**
     * 获取指定日期的0点时间
     *
     * @param date
     * @return
     */
    public static Date getTimesmorning(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.withTime(0, 0, 0, 0).toDate();
    }

    /**
     * 该时间加小时
     * @param date
     * @param hours
     * @return
     */
    public static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static Date parseDate(String dateStr, String pattern) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(dateStr, pattern);
        } catch (ParseException e) {
            logger.error("解析日期格式出错:{}-{}", dateStr, pattern, e);
            return null;
        }
    }


}

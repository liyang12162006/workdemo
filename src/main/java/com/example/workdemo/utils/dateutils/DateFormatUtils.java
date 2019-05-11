package com.example.workdemo.utils.dateutils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yangyangl
 * @date 2019-01-18 20:32
 */
public class DateFormatUtils {

    /**
     * 1970
     */
    public static final String PATTERN_YYYY = "yyyy";
    /**
     * 197001
     */
    public static final String PATTERN_YYYYMM = "yyyyMM";


    // Patterns
    /**
     * 1970-01
     */
    public static final String PATTERN_YYYY_MM = "yyyy-MM";
    /**
     * 19700101
     */
    public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
    /**
     * 1970010101
     */
    public static final String PATTERN_YYYYMMDDHH = "yyyyMMddHH";
    /**
     * 197001010101
     */
    public static final String PATTERN_YYYYMMDDHHMM = "yyyyMMddHHmm";
    /**
     * 19700101010101
     */
    public static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    /**
     * 1970-01-01
     */
    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * 1970-01-01 01
     */
    public static final String PATTERN_YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    /**
     * 1970-01-01 01:01
     */
    public static final String PATTERN_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:MM";
    /**
     * 1970-01-01 01:01:01
     */
    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 1970-01-01 01:01:01.123
     */
    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String PATTERN_YMONTH_DDAY = "M月d日";

    public static final String[] DATE_FORMAT = new String[]{"yyyy-MM-dd"};

    private final static Logger logger = LoggerFactory.getLogger(DateFormatUtil.class);

   // private final static DateTimeZone dateTimeZone = DateTimeZone.getDefault();

    /**
     * 字符串1990-10-10转换成date
     *
     * @param date
     * @return
     */
    public static Date parseDate(String date, String format) throws Exception {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            return DateUtils.parseDate(date, format);
        } catch (ParseException e) {
            logger.error("日期格式错误{}", date, e);
            throw new Exception("日期格式不正确");
        }
    }

    /**
     * 字符串1990-10-10转换成date
     *
     * @param date
     * @return
     */
    public static Date parseDate(String date) throws Exception {
        return parseDate(date, PATTERN_YYYY_MM_DD);
    }

    /**
     * 20151111 to  2015-11-11
     *
     * @param date YYYYMMDD
     * @return
     */
    public static String formatIntDate(int date) {
        if (date <= 0) {
            return StringUtils.EMPTY;
        }
        String dateStr = String.valueOf(date);
        if (dateStr.length() != 8) {
            return StringUtils.EMPTY;
        }
        char[] chars = new char[10];
        for (int i = 0, j = 0; i < 10; i++) {
            if (i == 4 || i == 7) {
                chars[i] = '-';
            } else {
                chars[i] = dateStr.charAt(j);
                j++;
            }
        }
        return new String(chars);
    }

    /**
     * 2015-11-11 转成 20151111
     *
     * @param date
     */
    public static Integer parseDateToInt(String date) throws Exception {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            Date date1 = DateUtils.parseDate(date, PATTERN_YYYY_MM_DD);
            String replace = org.apache.commons.lang3.time.DateFormatUtils.format(date1, PATTERN_YYYYMMDD);
            return Integer.valueOf(replace);
        } catch (NumberFormatException | ParseException e) {
            logger.error("日期格式错误{}", date, e);
            throw new Exception("日期格式不正确");
        }
    }

    /**
     * 2015-11-11 转成 20151111
     *
     * @param date
     */
    public static Integer parseDateToInt(Date date) throws Exception {
        if (date == null) {
            return null;
        }
        try {
            String replace = org.apache.commons.lang3.time.DateFormatUtils.format(date, PATTERN_YYYYMMDD);
            return Integer.valueOf(replace);
        } catch (NumberFormatException e) {
            logger.error("日期格式错误{}", date, e);
            throw new Exception("日期格式不正确");
        }
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null || StringUtils.isBlank(pattern)) {
            return null;
        }

        return org.apache.commons.lang3.time.DateFormatUtils.format(date, pattern);
    }

    public static String safeFormatDate(Calendar date, String pattern) {
        if (date == null || StringUtils.isBlank(pattern)) {
            return null;
        }

        return org.apache.commons.lang3.time.DateFormatUtils.format(date, pattern);
    }

    /**
     * 将字符串格式的时间格式化
     *
     * @param date
     * @return
     */
    public static String formatDateYYYYMMDD(String date) throws Exception {
        try {
            Date date1 = DateUtils.parseDate(date, PATTERN_YYYYMMDD);
            return org.apache.commons.lang3.time.DateFormatUtils.format(date1, PATTERN_YYYYMMDD);
        } catch (ParseException e) {
            throw new Exception("时间解析错误");
        }
    }

    /**
     * Y月M日
     *
     * @param date
     * @return
     */
    public static String formatDateYM(Date date) {
        if (date == null) {
            return null;
        }
        return org.apache.commons.lang3.time.DateFormatUtils.format(date, PATTERN_YMONTH_DDAY);
    }

//
//    /**
//     * 把时间格式转成Y月M日格式
//     * @param date
//     * @return
//     */
//    public static String formatIntDate2YD(Integer date) {
//        final Date tmpDate = DateTime.parse(formatIntDate(date)).toDate();
//        return DateFormatUtils.formatDate(tmpDate, PATTERN_YMONTH_DDAY);
//    }

//    /**
//     *
//     * @param date YYYYMMDD
//     * @return
//     */
//    public static Date formatIntDate2Date(Integer date){
//        return LocalDate.parse(formatIntDate(date)).toDate();
//    }
//
//    /**
//     *
//     * @param date YYYYMMDD
//     * @return
//     */
//    public static LocalDate formatIntDate2LocalDate(Integer date){
//        return LocalDate.parse(formatIntDate(date));
//    }

    /**
     * 将字符串格式的时间格式化
     *
     * @param date
     * @return
     */
    public static String formatDateYYYY_MM_DD(String date) throws Exception {
        try {
            Date date1 = DateUtils.parseDate(date, PATTERN_YYYYMMDD);
            return org.apache.commons.lang3.time.DateFormatUtils.format(date1, PATTERN_YYYY_MM_DD);
        } catch (ParseException e) {
            throw new Exception("时间解析错误");
        }
    }

//    /**
//     *
//     * @param intDate YYYYMMDD
//     * @return
//     */
//    public static String formatDateYYYY_MM_DD(int intDate) {
//        return formatIntDate2LocalDate(intDate).toString();
//    }


//    public static String getMonth(Date date) {
//        DateTime dateTime = new DateTime(date);
//        return String.valueOf(dateTime.getMonthOfYear());
//    }
//
//    public static String getDay(Date date) {
//        DateTime dateTime = new DateTime(date);
//        return String.valueOf(dateTime.getDayOfMonth());
//    }
}

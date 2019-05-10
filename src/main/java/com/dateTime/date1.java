package com.dateTime;

import java.time.LocalDate;
import java.time.LocalTime;

;

/**
 * @author yangyangl
 * @time 2018-8-31 19:08:04
 */
public class date1 {



    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int mouth = today.getMonthValue();
        int day =  today.getDayOfMonth();
        System.out.println("today---"+today+"--"+year+"-"+mouth+"-"+day+"-"  );

        LocalTime time = LocalTime.now();

        LocalTime newTime = time.plusHours(2);

        System.out.println("time--"+time+"-newTime-"+newTime);

        String ss = today+" "+time;
        System.out.println("ss--"+ss);
    }



}

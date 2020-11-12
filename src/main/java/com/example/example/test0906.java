package com.example.example;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yangyangl
 * @date 2018-09-06 15:28
 */
public class test0906 {

    public static void main(String[] args) {
        String a = "233131321 ";
        System.out.println("a"+a);
        long aa = Long.valueOf(StringUtils.trim(a));
        int aaa = Integer.valueOf(StringUtils.trim(a));
        System.out.println("aa"+ aa);
        System.out.println("aaa"+aaa);

    }
}

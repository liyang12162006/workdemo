package com.example.example.test;

/**
 * @author yangyangl
 * @date 2018-10-30 14:34
 */
public class test1030 {
    public static void main(String[] args) {

        System.out.println("1----" + (31 & 32));
        System.out.println("2----" + (0 & 32));
        System.out.println("3----" + (32 & 32));
        System.out.println("4----" + (33 & 32));
        System.out.println("5----" + (10 & 32));
        System.out.println("6----" + (-1 & 32));
        System.out.println("7----" + (-10 & 32));
        System.out.println("8----" + (100 & 32));
        System.out.println("9----" + (127 & 32));
        System.out.println("10----" + (128 & 32));
        System.out.println("11----" + (129 & 32));
        System.out.println("11---------------");
        System.out.println("9----" + (-127 & 32));
        System.out.println("10----" + (-128 & 32));
        System.out.println("11----" + (-129 & 32));

    }
}

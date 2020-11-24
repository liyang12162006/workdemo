package com.example.suanfa;


/**
 * @author liyangyang
 * @date 2020/11/11 17:34
 * @since 2.4.0.0
 */
public class Fibonacci {

    public static void main(String[] args) {
        for (Integer a: Fibonacci(14)) {
            System.out.println(a);
        }
    }


    public static int[] Fibonacci(int n){
        int[] a = new int[n];
        a[0] = a[1] = 1;
        for (int i = 2; i <n ; i++) {
            a[i] = a[i-2] + a[i-1];
        }
        return  a;
    }
}

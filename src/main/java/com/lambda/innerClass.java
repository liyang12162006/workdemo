package com.lambda;

public class innerClass {
    public static  int i = 0;

    public static void main(String[] args) {
        new Thread(){
            public void run(){
             i++;
                System.out.printf("---"+i);
            };
        }.start();

    }


}

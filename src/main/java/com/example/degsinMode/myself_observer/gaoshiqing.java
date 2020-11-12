package com.example.degsinMode.myself_observer;

/**
 * @author yangyangl
 * @date 2019-01-31 11:52
 */
public class gaoshiqing {
    public static void main(String[] args) {
        dage d = new dage();


        xiaoDi xiaoDi1 = new xiaoDi("lili");
        xiaoDi xiaoDi2 = new xiaoDi("niu");
        xiaoDi xiaodi3 = new xiaoDi("yang");
        zhongjixiaodi z = new zhongjixiaodi("网上那");


        d.registerObserver(z);
        d.registerObserver(xiaoDi1);
        d.registerObserver(xiaoDi2);
        d.registerObserver(xiaodi3);
        d.sethuodong("王刚");

        d.removeObserver(xiaoDi2);

        d.sethuodong("晓得撒");
    }







}

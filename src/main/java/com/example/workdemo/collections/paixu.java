package com.example.workdemo.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author yangyangl
 * @date 2019-02-05 14:55
 */
public class paixu {

    public static void main(String[] args) {
        Random rd = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        // System.out.println(Math.random());
        while(true) {
            int temp = rd.nextInt(36)+1;
            if(!arr.contains(temp)) {
                arr.add(temp);
            }
            if(arr.size()==7) {break;}
        }
        Collections.sort(arr);  //升序排列

        //第一种：输出方式
        System.out.println(Arrays.toString(arr.toArray()));

       //第二种：输出方式
        //for(int i :arr){
        //  System.out.print(i+"  ");
        //}

        Collections.sort(arr,Collections.reverseOrder()); //降序排列
        System.out.println(Arrays.toString(arr.toArray()));
        Collections.reverse(arr);
        System.out.println(Arrays.toString(arr.toArray()));

    }
}

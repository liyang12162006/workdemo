package com.example.suanfa;

import java.util.ArrayList;

/**
 * @author yangyangl
 * @date 2019-02-05 9:07
 */
public class binarySearch {
    public static void main(String[] args) {



    }

    public static  int binarySearch (int[] arr , int x){

        int min = 0;
        int max = arr.length;
        int mid = 0;
        while (max >= min){
            mid = (max + min ) / 2;
            if (arr[mid] > x){
                max = mid - 1;
            }else if (arr[mid] < x){
                min = mid + 1;
            }else {
                return mid;
            }
        }
        return  -1;
    }
}

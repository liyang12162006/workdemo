package com.example.suanfa;

/**
 * @author liyangyang
 * @date 2020/11/12 09:49
 * @since 2.4.0.0
 */
public class InsertSort {

    public static void main(String[] args) {
        //        int[] arr = {2, 5, 1, 3, 8, 5, 7, 4, 3};
        int arr[] = { 54, 78, 0, 23, 8, 70, 2, 900, 4561 };
        //冒泡
        //bubbleSort(arr);

        //快速排序
        InsertSort(arr);
        for (Integer i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 自己写的
     * @author liyangyang
     * @date 2020-11-12 10:45
     * @since 2.9.0.0
     *
     */
    public static void InsertSort(int arr[]){
        if (arr.length == 1){
            return;
        }
        for (int i = 1; i < arr.length ; i++) {
            //当前值
            int currentValue = arr[i];
            //要进行插入的位置
            int insertIndex = i-1;
            while (insertIndex >= 0 && currentValue < arr[insertIndex]){
                swap(arr,i,insertIndex);
                insertIndex --;
                i--;
            }




        }

    }


    public static void swap(int[] data, int a, int b) {
        int t = data[a];
        data[a] = data[b];
        data[b] = t;

    }


}

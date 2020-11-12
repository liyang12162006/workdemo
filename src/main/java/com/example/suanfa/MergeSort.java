package com.example.suanfa;

import java.util.Arrays;

/**
 * @author liyangyang
 * @date 2020/11/12 13:57
 * @since 2.4.0.0
 */
public class MergeSort {

    public static void main(String[] args) {
        //        int[] arr = {2, 5, 1, 3, 8, 5, 7, 4, 3};
        //快速排序
        long now =System.currentTimeMillis();
//        for (int i = 0; i <100000 ; i++) {
            int arr[] = {54,78,78,78,78, 78, 0, 23, 8, 70, 2, 900, 4561};
            print(arr, "排序前的");
            arr = mergeSort(arr);
            print(arr, "排序后的");
//        }
       long time = System.currentTimeMillis() - now;

        System.out.println("------：" + time);

    }

    private static int[] mergeSort(int arr[]) {
        int length = arr.length;
        if(length < 2) {
            return arr;
        }
        int mid = length / 2;

        int leftArr[] = Arrays.copyOfRange(arr, 0, mid);
        int rightArr[] = Arrays.copyOfRange(arr, mid, length);
//        print(leftArr, "左侧");
//        print(rightArr, "右侧");

        return merger(mergeSort(leftArr), mergeSort(rightArr));

    }

    public static int[] merger(int leftArr[], int rightArr[]) {
        int[] result = new int[leftArr.length + rightArr.length];
        int l = 0;
        int r = 0;
        int k = 0;

        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] < rightArr[r]) {
                result[k++] = leftArr[l++];
            } else if (leftArr[l] > rightArr[r]) {
                result[k++] = rightArr[r++];
            } else if (leftArr[l] == rightArr[r]) {
                result[k++] = rightArr[r++];
                result[k++] = leftArr[l++];
            }

        }
        while (l < leftArr.length) {
            result[k++] = leftArr[l++];
        }

        while (r < rightArr.length) {
            result[k++] = rightArr[r++];
        }

        return result;
    }

    private static void print(int arr[], String name) {
        System.out.println("---" + name + "----：" + Arrays.toString(arr));
    }




}

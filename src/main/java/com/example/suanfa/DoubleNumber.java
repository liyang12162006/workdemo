package com.example.suanfa;

import com.example.workdemo.utils.JsonUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://mp.weixin.qq.com/s/4r5sHH6gTv8gPnBCHNGZ_g
 *
 * 题目说明：在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：[2, 3, 1, 0, 2, 5, 3] 输出：2 或 3
 *
 * @author liyangyang
 * @date 2020/11/24 10:15
 * @since 2.4.0.0
 */

public class DoubleNumber {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 1, 2, 2, 2, 5, 7};
        Set<Integer> integers= new HashSet<>();

        //integers = fetchDoubleNumber(arr);


        integers = fetchDoubleNumberHash(arr);


        System.out.println(JsonUtils.writeObjectAsStringSilently(integers));
    }

    private static Set<Integer> fetchDoubleNumber(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i] == arr[i-1]){
                result.add(arr[i]);
            }
        }
        return result;
    }

    private static Set<Integer> fetchDoubleNumberHash(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        for (Integer i :arr) {
            if(map.containsKey(i)){
                result.add(i);
            }else{
                map.put(i,1);
            }
        }
        return result;
    }


}

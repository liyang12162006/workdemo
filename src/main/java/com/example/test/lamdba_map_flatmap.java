package com.example.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangyangl
 * @date 2019-02-13 14:11
 */
public class lamdba_map_flatmap {


    /**
     * Stream的map和flatMap的区别:
     * map会将一个元素变成一个新的Stream
     * 但是flatMap会将结果打平，得到一个单个元素
     */
        public static void main(String[] args) {
//            /**获取单词，并且去重**/
//            List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",
//                    "hello world welcome");
//
//            //map和flatmap的区别
//            list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
//            System.out.println("---------- ");
//            list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
//
//            //实际上返回的类似是不同的
//            List<Stream<String>> listResult = list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());
//            List<String> listResult2 = list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());
//
//            System.out.println("---------- ");
//
//            //也可以这样
//            list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
//
//            System.out.println("================================================");

            /**相互组合**/
            List<String> list2 = Arrays.asList("hello", "hi", "你好");
            List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

            list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
            System.out.println("===================================1=============");
            list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
            System.out.println("=================================2===============");
            //实际上返回的类似是不同的
            List<Stream<String>> list2Result = list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
            System.out.println("--list2Result"+list2Result);
            System.out.println("=============================3===================");
            List<String> list2Result2 = list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
            System.out.println("--list2Result2"+list2Result2);

            System.out.println("=============================4===================");


        }

}

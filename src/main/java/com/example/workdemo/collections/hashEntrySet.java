package com.example.workdemo.collections;

import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangyangl
 * @date 2019-01-31 10:32
 */
public class hashEntrySet {

    public static void main(String[] args) {

        HashMap<Object, String> hashMap = Maps.newHashMap();
        hashMap.put("1", "小明");
        hashMap.put("2", "小强");
        hashMap.put("3", "小新");
        HashSet set = new LinkedHashSet();
        for (Map.Entry<Object, String> entrySet : hashMap.entrySet()) {
            System.out.println("key :" + entrySet.getKey() + "----value :" + entrySet.getValue());
            set.add(entrySet.getKey());
            set.add(entrySet.getValue());
        }
        generate(10);
    }


    public static void convertLiat() {

        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("333");
        list.add("444");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("-----------");
        for (String s : list) {
            System.out.println("---" + s);
        }
        System.out.println("----------");
        System.out.println("--" + list.stream().findFirst().get());
        List<String> list2 = new ArrayList<>();
        list.forEach(s -> {
            s = s + "--";
            list2.add(s);
        });
        List<String> list3 = list2.stream().skip(1).limit(1).collect(Collectors.toList());
        for (String s : list3) {
            System.out.println("==" + s);
        }
        list.forEach(s -> {
            System.out.println(s);
        });

        list.stream().forEach(s -> {
            System.out.println(s);
        });

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lastList = new ArrayList<List<Integer>>();

        if (numRows < 1) {
            return lastList;
        }

//        List<Integer> ziList = new ArrayList<Integer>();
//        List<Integer> ziList2 = new ArrayList<Integer>();
//        lastList.add(ziList);
//        ziList.add(1);
//
//        lastList.add(ziList2);
//        ziList2.add(1);
//        ziList2.add(1);


        lastList.add(new ArrayList<>());
        lastList.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = lastList.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            lastList.add(row);
        }

        for (List<Integer> list : lastList) {
            for (Integer integer : list) {
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println();
        }
    return lastList;
    }


}

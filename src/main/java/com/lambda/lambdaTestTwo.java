package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangyangl
 * @date 2018-09-18 20:21
 */
public class lambdaTestTwo {

    public static void main(String[] args) {

        //初始对象并准备集合数据
        myObject obj1 = new myObject();
        obj1.setX(1);
        obj1.setY(1);
        obj1.setText("a");

        myObject obj2 = new myObject();
        obj2.setX(2);
        obj2.setY(2);
        obj2.setText("a");

        myObject obj3 = new myObject();
        obj3.setX(3);
        obj3.setY(3);
        obj3.setText("a");

        myObject obj4 = new myObject();
        obj4.setX(4);
        obj4.setY(4);
        obj4.setText("d");

        myObject obj5 = new myObject();
        obj5.setX(5);
        obj5.setY(5);
        obj5.setText("d");

        List<myObject> ls = new ArrayList<myObject>();
        ls.add(obj1);
        ls.add(obj2);
        ls.add(obj3);
        ls.add(obj4);
        ls.add(obj5);

        /** 把x >= 3 的集合找出来 **/
        List<myObject> filter1 = ls.stream().filter(t -> t.getX() >= 3).collect(Collectors.toList());

        filter1.forEach(t -> System.out.println(t.getX()));

        System.out.println("-----------------------------");

        /** 求text=d 的记录总数 **/
        long count = ls.stream().filter(t -> t.text == "d").count();

        System.out.println(count);
        System.out.println("-----------------------------");

        /** 汇总x，y,及(x+y) 集合 **/

        // 求x总和
        int xSum = ls.stream().mapToInt(item -> item.x).sum();
        System.out.println(xSum);
        System.out.println("-----------------------------");
        // 求y总和
        int ySum = ls.stream().mapToInt(item -> item.y).sum();
        System.out.println(ySum);
        System.out.println("-----------------------------");
        // 求x+y总和
        int Sum = ls.stream().mapToInt(item -> item.x + item.y).sum();
        System.out.println(Sum);
        System.out.println("-----------------------------");
        // 求x平均值
        double xAvg = ls.stream().mapToDouble(item -> item.x).average().getAsDouble();
        System.out.println(xAvg);
        System.out.println("-----------------------------");
        // 根据text统计x，y的总和
        Map<String, Integer> group1 = ls.stream()
                .collect(Collectors.groupingBy(t -> t.text, Collectors.summingInt(t -> t.x)));

        System.out.println("a:" + group1.get("a"));
        System.out.println("d:" + group1.get("d"));
        System.out.println("-----------------------------");
        // 过滤text=d 的记录，并把x值都设置为10
        ls.stream().filter(t -> t.text == "d").forEach(s -> s.setX(10));

        ls.forEach(t -> System.out.println(t.x));
        System.out.println("-----------------------------");
    }
}

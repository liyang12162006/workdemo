package com.example.workdemo.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author yangyangl
 * @date 2019-01-30 20:47
 */
public class MapEntrySetTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Map<Integer, String> map=new HashMap<Integer, String>();
        map.put(8, "wangwu");
        map.put(2, "lisi");
        map.put(7, "zhangsan");
        map.put(6, "xuliu");
        System.out.println("----"+map.toString());
        method_3(map);
    }

    private static void method_3(Map<Integer, String> map) {
        Set entrySet=map.entrySet();//entrySet()方法返回反应map键值的映射关系，存储在set集合中
        System.out.println(entrySet.toString());
        Iterator it=entrySet.iterator();//使用迭代器获得每一个映射关系
        while(it.hasNext()){
            Map.Entry me=(Map.Entry) it.next();//映射关系类型为Map.Entry类型，是一个接口类型
            System.out.println(me.getKey()+":::"+me.getValue());
//   System.out.println(me.getValue());
        }

    }
}

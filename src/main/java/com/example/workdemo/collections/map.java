package com.example.workdemo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.util.CollectionUtils;

public class map {

    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("id1", "1111");
        map1.put("name1", "1111");

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("id2", "1111");
        map2.put("name2", "1111");

        list.add(map1);
        list.add(map2);

        System.out.println(list.toString());

        // convent(list);
        System.out.println("1111---" + list.toString());

        System.out.println("-----------" + map2.get("id2"));

        for (String s : map2.keySet()) {
            System.out.println("------111-----" + s);
            System.out.println("-----111------" + map2.get(s));
        }
    }

    public static void convent(List<Map<String, Object>> list) {
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("空数据");
        }

        for (Map<String, Object> itemMap : list) {

            if (itemMap.containsKey("id1")) {
                itemMap.put("address", "1111");
            }
        }

    }
}

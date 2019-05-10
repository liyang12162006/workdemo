package com.collections;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yangyangl
 * @date 2018-09-17 16:37
 */
public class test {
    public static void main(String[] args) {

        ArrayList<HashMap<String, Object>> list = new ArrayList();
        HashMap<String, Object> map = new HashMap<>();
        list.add(map);
        map.put("id", "111");
        map.put("name", "namea");
        System.out.println(list);
    }
}

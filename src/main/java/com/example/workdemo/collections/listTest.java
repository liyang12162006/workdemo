package com.example.workdemo.collections;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

public class listTest {
    public static void main(String[] args) {

        List<String > list = Arrays.asList("id","112","wqwq","asad");

        for (String s : list) {
            System.out.println("--"+s);

        }
        System.out.println(CollectionUtils.isEmpty(list));
        String a = StringUtils.EMPTY;
        if(StringUtils.isBlank(a)){
            System.out.println("空的");
        }
        System.out.println("--"+a);
    }
}

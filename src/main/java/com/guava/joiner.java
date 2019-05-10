package com.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yangyangl
 * @date 2018-11-01 11:57
 */
public class joiner {
    public static void main(String[] args) {
        /** 跳过空对象 */
        Joiner joiner = Joiner.on(",").skipNulls();
        String str = joiner.join("Harry", null, "Ron", "Hermione");
        System.out.println("str" + str);

        Splitter splitter = Splitter.onPattern(",").omitEmptyStrings().trimResults();
        Iterable<String> it = splitter.split(str);
        List<String> result = Lists.newArrayList(it);
        result.forEach(System.out::println);
        System.out.println("---------------");

        String s = "  ";
        System.out.println(Strings.isNullOrEmpty(s));
        System.out.println(StringUtils.isBlank(s));

    }

}

package com.example.utils;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

/**
 * 集合工具 扩展 {@link CollectionUtils}
 *
 * @author zhaoke
 * @since 2019/12/13
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectionUtil extends CollectionUtils {

    public static boolean isEmpty(Map coll) {
        return (coll == null || coll.isEmpty());
    }

    public static boolean isNotEmpty(Map coll) {
        return !isEmpty(coll);
    }

    /**
     * 转换为Set
     */
    public static <F, T> Set<F> transSet(Collection<T> coll, Function<? super T, ? extends F> mapper) {
        if (isEmpty(coll)) {
            return Collections.emptySet();
        }
        return coll.stream().map(mapper).collect(Collectors.toSet());
    }

    /**
     * 转换为List
     */
    public static <F, T> List<F> transList(Collection<T> coll, Function<? super T, ? extends F> mapper) {
        if (isEmpty(coll)) {
            return Collections.emptyList();
        }
        return coll.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * 转换为去重的List
     */
    public static <F, T> List<F> distinctList(Collection<T> coll, Function<? super T, ? extends F> mapper) {
        if (isEmpty(coll)) {
            return Collections.emptyList();
        }
        return coll.stream().map(mapper).distinct().collect(Collectors.toList());
    }

    /**
     * 去重
     */
    public static <T> List<T> distinctList(Collection<T> coll) {
        if (isEmpty(coll)) {
            return Collections.emptyList();
        }
        return coll.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 转换
     */
    public static <T, A, R> R collect(Collection<T> coll, Collector<? super T, A, R> collector) {
        return coll.stream().collect(collector);
    }

    /**
     * 转换为Map-List
     */
    public static <T, F> Map<F, List<T>> groupIndex(Collection<T> coll, Function<? super T, ? extends F> mapper) {
        if (isEmpty(coll)) {
            return Collections.emptyMap();
        }
        return coll.stream().collect(Collectors.groupingBy(mapper));
    }

    /**
     * 转换为Map-List
     */
    public static <T, F, R> Map<F, List<R>> groupIndex(Collection<T> coll, Function<? super T, ? extends F> group, Function<? super T, ? extends R> mapper) {
        if (isEmpty(coll)) {
            return Collections.emptyMap();
        }
        return coll.stream().collect(Collectors.groupingBy(group, Collectors.mapping(mapper, Collectors.toList())));
    }

    /**
     * 转换为Map-Value
     */
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> values, Function<? super V, K> function) {
        if (values == null) {
            return ImmutableMap.of();
        }
        return Maps.uniqueIndex(values, function::apply);
    }

    /**
     * 转换为Map-Value
     */
    public static <K, V> Map<K, V> index(Iterable<V> values, Function<? super V, K> function) {
        Map<K, V> map = new HashMap<>();
        if (values == null) {
            return map;
        }
        for (V item : values) {
            map.put(function.apply(item), item);
        }
        return map;
    }

    /**
     * 转换为Map-Value
     */
    public static <K, V, T> Map<K, V> index(Iterable<T> values, Function<? super T, K> keyFunction, Function<? super T, V> valueFunction) {
        Map<K, V> result = new HashMap<>();
        if (values == null) {
            return result;
        }
        for (T item : values) {
            result.put(keyFunction.apply(item), valueFunction.apply(item));
        }
        return result;
    }

    public static String join(List<String> list, String separator) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String ele : list) {
            if (sb.length() > 0) {
                sb.append(separator);
            }
            sb.append(ele);
        }
        return sb.toString();
    }

    /**
     * 保持原来顺序返回list分组
     *
     * @param list key不会跳着分布
     */
    private static <K, V> List<List<V>> groupList(List<V> list, Function<? super V, K> function) {
        List<List<V>> result = new ArrayList<>();
        K cutKey = null;
        List<V> resultItem = new ArrayList<>();
        for (V item : list) {
            K key = function.apply(item);
            if (cutKey == null || !cutKey.equals(key)) {
                cutKey = key;
                resultItem = new ArrayList<>();
                result.add(resultItem);
            }
            resultItem.add(item);
        }
        return result;
    }

    /**
     * 判断数组是否含有某个元素
     */
    public static <T> boolean contains(T[] array, T t) {
        if (array == null) {
            return false;
        }
        for (T item : array) {
            if (item == t) {
                return true;
            }
        }
        return false;
    }


    /**
     * 从list里根据唯一字段值 查找
     */
    public static <T, F> T find(List<T> list, Function<? super T, F> function, F value) {
        for (T t : list) {
            if (value.equals(function.apply(t))) {
                return t;
            }
        }
        return null;
    }
}

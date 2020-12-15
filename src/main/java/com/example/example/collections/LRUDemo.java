package com.example.example.collections;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author liyangyang
 * @date 2020/12/08 09:52
 * @since 2.4.0.0
 */
public class LRUDemo<k,v> extends LinkedHashMap<k,v> {


    private Integer capacity;

    /**
     * Constructs an empty <tt>LinkedHashMap</tt> instance with the specified initial capacity, load factor and ordering
     * mode.
     *
     * @param capacity the initial capacity
     * @param loadFactor the load factor
     * @param accessOrder the ordering mode - <tt>true</tt> for access-order, <tt>false</tt> for insertion-order
     *
     * @throws IllegalArgumentException if the initial capacity is negative or the load factor is nonpositive
     */
    public LRUDemo(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Entry<k, v> eldest) {

        System.out.println("----开始删除了"+ (super.size() > capacity));
        return super.size() > capacity;
    }


    public static void main(String[] args) {

        LRUDemo demo = new LRUDemo(3);

        demo.put(1,1);
        demo.put(2,2);
        demo.put(3,3);
        System.out.println(demo.keySet());

        demo.put(4,4);
        System.out.println(demo.keySet());
        demo.get(3);
        System.out.println(demo.keySet());
        demo.get(3);
        System.out.println(demo.keySet());




    }



}

package com.example.workdemo.threadPool.HtYeXiangYangDemo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author : liyangyang
 * @date 2019-05-13 20:01
 */
public interface IEnum<T> {

    T getValue();

    String getTitle();

}

package com.example.enums;

import java.io.Serializable;

/**
 * @author yangyangl
 * @date 2018-10-25 14:33
 */
public interface BaseEnum extends Serializable {

    public abstract int getCode();

    public abstract String getDesc();
}

package com.example.workdemo.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yangyangl
 * @date 2018-8-31 15:52:15
 */
@Data
@AllArgsConstructor
public class people implements Serializable {


    private static final long serialVersionUID = -151780769592730648L;


    private String name;

    private Integer age;

    private String address;



}

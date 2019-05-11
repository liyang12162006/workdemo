package com.example.workdemo.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author yangyangl
 * @date 2018-8-31 15:52:15
 */
@Data
@AllArgsConstructor
@Component
public class People implements Serializable {
    private static final long serialVersionUID = -151780769592730648L;
    private String name;

    private Integer age;

    private String address;



}

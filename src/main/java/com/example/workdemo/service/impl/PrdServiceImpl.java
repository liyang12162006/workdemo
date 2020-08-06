package com.example.workdemo.service.impl;

import com.example.workdemo.aoputils.aop.SystemLog;
import com.example.workdemo.service.PrdService;
import org.springframework.stereotype.Service;

/**
 * @author liyangyang
 * @date 2020/08/06 16:15
 * @since 2.4.0.0
 */
@Service
public class PrdServiceImpl implements PrdService {
    @Override
    @SystemLog(methoddesc = "okok")
    public String fetchName(String name) {
        System.out.println("进来了---");
        return name+"好！！";
    }
}

package com.example.workdemo.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 心跳地址检测
 *
 * @author shitianshu on 16/3/9 下午11:40.
 */
@RestController
public class RoukController {

    @RequestMapping("/ruok")
    public void rouk(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().print("OK");
    }
}

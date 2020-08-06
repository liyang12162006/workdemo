package com.example.workdemo.aoptest;

import com.example.workdemo.service.PrdService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liyangyang
 * @date 2020/08/06 16:18
 * @since 2.4.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class prdServiceTest {

    @Resource
    private PrdService prdService;

    @Test
    public void testisSimple(){
        try {
            System.out.println(prdService.fetchName("张三"));
        } catch (Exception e) {
            log.error("ceshi :", e);
        }
    }
}
package com.example.workdemo.aoputils.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 系统日志注解（使用在Service类里面的方法上）
 * @author liyangyang
 * @date 2020/08/06 16:09
 * @since 2.4.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SystemLog {
    String methoddesc() default "";//方法描述
}
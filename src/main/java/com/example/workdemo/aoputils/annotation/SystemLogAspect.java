package com.example.workdemo.aoputils.annotation;

import com.google.gson.Gson;
import com.example.workdemo.aoputils.aop.SystemLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author liyangyang
 * @date 2020/08/06 16:10
 * @since 2.4.0.0
 */
@Component
@Aspect
@Slf4j
public class SystemLogAspect {

    // @SystemLog标识为切入点，切面会根据@SystemLog注解来注入数据
    @Pointcut("@annotation(com.example.workdemo.aoputils.aop.SystemLog)")
    public void logPointCut(){
    }

    //环绕注入
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();//记录目标方法的开始执行时间
        Object result = point.proceed();//执行目标方法
        long methodexecutetime = System.currentTimeMillis() - startTime;

        //日志信息记录
        try {
            MethodSignature methodSignature = (MethodSignature) point.getSignature();
            Method method = methodSignature.getMethod();
            SystemLog systemLog = method.getDeclaredAnnotation(SystemLog.class);
            String className = point.getTarget().getClass().getName();//类名
            String methodName = method.getName();//方法名

            //入参信息
            Object[] args = point.getArgs();
            List<String> list = new ArrayList<String>();
            for (Object obj : args) {
                list.add(new Gson().toJson(obj));
            }
            log.info(className+"."+methodName+"，"+systemLog.methoddesc()+",入参："+list.toString());
            log.info(className+"."+methodName+"，"+systemLog.methoddesc()+"，耗时："+methodexecutetime+"ms");
        } catch (Exception e) {
            log.error("日志切入出错");
        }
        return result;
    }
}
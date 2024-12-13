package com.marouaneLasmak.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {
    Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Around("@annotation(Log)")
    public Object logBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long t2 = System.currentTimeMillis();
        System.out.println("Duration :"+(t2-t1));
        return result;
    }
}

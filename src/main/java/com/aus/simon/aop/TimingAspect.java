package com.aus.simon.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class TimingAspect {
    @Pointcut("execution(* com.aus.simon.sort..*(..)) ")
    public void entry() {
    }
    
    @Around("entry()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        }
        finally {
            long endTime = System.currentTimeMillis();
            
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method targetMethod = methodSignature.getMethod();
            
            
            System.out.println("====" + targetMethod.getName() + "() costs " + (endTime - startTime) + "ms");
        }
    }
}

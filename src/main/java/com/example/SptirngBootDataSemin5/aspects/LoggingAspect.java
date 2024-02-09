package com.example.SptirngBootDataSemin5.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.SptirngBootDataSemin5.services.*.*(..))")
    public void logBeforeMethodServices(JoinPoint joinPoint){
        System.out.println("= Aspect = method " + joinPoint.getSignature().getName() + "был вызван");
        Object[] args = joinPoint.getArgs();
        if(args.length > 0)
            System.out.println("== с аргументами:");
        for (Object arg : args) {
            System.out.println("=== " + arg.toString());
        }
    }
}

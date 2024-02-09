package com.example.SptirngBootDataSemin5.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * класс аспектов
 */
@Aspect
@Component
public class LoggingAspect {
    /**
     * аспект по анализу метода, который был вызван,
     * обрабатывает все методы в пакете services до выполнения
     * @param joinPoint
     */
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

    /**
     * аспект будет обрабатывать методы, помеченные аспектом TrackUserAction
     * (прикреплен к методу getAllTasks сервиса TaskServiceImpl
     * @param returnedValue
     */
    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue")
    public void logAction(Object returnedValue){
        System.out.println("-- Обработали аспектом TrackUserAction" + returnedValue);
    }
}

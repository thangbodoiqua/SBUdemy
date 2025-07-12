package com.example.SBUdemy.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution( * com.example.SBUdemy.dao.*.*(..))")
    private void forDAOPackage() {};

//    @Before("execution(public void addAccount())")
    @Before("forDAOPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==> Executing @Before advice on method");
    }

    @Before("forDAOPackage()")
    public void performApiAnalytics() {

        System.out.println("\n==> Performing API analytics");
    }
}

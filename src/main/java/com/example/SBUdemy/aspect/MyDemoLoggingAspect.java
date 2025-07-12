package com.example.SBUdemy.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
//    @Before("execution(public void addAccount())")
    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n==> Executing @Before advice on addAccount()");

    }

}

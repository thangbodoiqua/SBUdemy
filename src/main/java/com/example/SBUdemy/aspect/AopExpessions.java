package com.example.SBUdemy.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpessions {
    @Pointcut("execution( * com.example.SBUdemy.dao.*.*(..))")
    public void forDAOPackage() {};

    @Pointcut("execution( * com.example.SBUdemy.dao.*.get*(..))")
    public void getter() {};

    @Pointcut("execution( * com.example.SBUdemy.dao.*.set*(..))")
    public void setter() {};

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter() {};
}

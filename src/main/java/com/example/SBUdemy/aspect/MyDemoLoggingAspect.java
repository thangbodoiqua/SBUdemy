package com.example.SBUdemy.aspect;

import com.example.SBUdemy.Account;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)

public class MyDemoLoggingAspect {
    @Around("execution(* com.example.SBUdemy.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint pjp
    ) throws Throwable {
        String method = pjp.getSignature().toShortString();

        System.out.println("\n==> Executing @Around on method: " + method);

//        long begin = System.currentTimeMillis();
        long begin = System.nanoTime();
        Object result = null;
        try {
            result = pjp.proceed();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            result = "Major accident! But safed";
        }

//        long end = System.currentTimeMillis();
        long end = System.nanoTime();
        long duration = end - begin;
        System.out.println("\n==> Duration: " + duration);

        return result;
    }

    @After("execution(* com.example.SBUdemy.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n==> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.SBUdemy.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint,
            Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n==> Executing @AfterThrowing on method: " + method);

        System.out.println("\n==> Exception is: " + theExc);


    }
    @AfterReturning(
            pointcut = "execution(* com.example.SBUdemy.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n==> Executing @AfterReturning on method: " + method);

        System.out.println("\n==> Result is: " + result);

        convertAccountNameToUpperCase(result);

    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        for(Account tempAccount: result) {
            tempAccount.setName(tempAccount.getName().toUpperCase());
        }
    }
    @Before("com.example.SBUdemy.aspect.AopExpessions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n==> Executing @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }


    }

}

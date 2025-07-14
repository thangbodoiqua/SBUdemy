package com.example.SBUdemy;

import com.example.SBUdemy.dao.AccountDAO;
import com.example.SBUdemy.dao.MembershipDAO;
import com.example.SBUdemy.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class SbUdemyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbUdemyApplication.class, args);
        System.out.println("http://localhost:2025");
    }
    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService) {
        return runner -> {
            demoTheAroundAdviceHandleException(theTrafficFortuneService);
        };
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\nMain program: demoTheAroundAdvice");

        System.out.println("Calling getFortune()");
        boolean tripWire = true;
        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished");
    }

    private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\nMain program: demoTheAroundAdvice");

        System.out.println("Calling getFortune()");

        String data = theTrafficFortuneService.getFortune();

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished");
    }


    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;

        try{
            boolean tripWire = true;

            theAccounts = theAccountDAO.findAccounts(tripWire);

        }catch (Exception exc){
            System.out.println("\n\nMain Program: ... caught exception" + exc);
        }

        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("------------        ------------------------------------------------------------");
        System.out.println(theAccounts);
        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

        List<Account> theAccounts = null;

        try{
            boolean tripWire = false;

            theAccounts = theAccountDAO.findAccounts(tripWire);

        }catch (Exception exc){
            System.out.println("\n\nMain Program: ... caught exception" + exc);
        }

        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("------------        ------------------------------------------------------------");
        System.out.println(theAccounts);
        System.out.println("\n");

    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = theAccountDAO.findAccounts();

        System.out.println("\n\nMain Program: demoAfterReturningAdvice");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(theAccounts);
        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        Account myAccount = new Account("Madhu", "Platinum");
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String code= theAccountDAO.getServiceCode();


        theMembershipDAO.addMember();
        theMembershipDAO.goToSleep();

    }
}
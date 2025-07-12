package com.example.SBUdemy.dao;

import com.example.SBUdemy.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + "Doing my db work : Add an account");

    }

    @Override
    public boolean doWork() {

        System.out.println(getClass() + "doWork()");

        return false;
    }

    @Override
    public String getName() {
        System.out.println(getClass() + "getName()");

        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass() + "setName()");
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass() + "getServiceCode()");

        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + "setServiceCode()");

        this.serviceCode = serviceCode;
    }
}

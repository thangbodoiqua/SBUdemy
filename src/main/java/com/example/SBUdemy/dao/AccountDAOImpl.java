package com.example.SBUdemy.dao;

import com.example.SBUdemy.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + "Doing my db work : Add an account");

    }

    @Override
    public boolean doWork() {

        System.out.println(getClass() + "doWork()");

        return false;
    }


}

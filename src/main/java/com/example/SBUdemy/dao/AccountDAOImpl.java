package com.example.SBUdemy.dao;

import com.example.SBUdemy.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount) {

        System.out.println(getClass() + "Doing my db work : Add an account");

    }


}

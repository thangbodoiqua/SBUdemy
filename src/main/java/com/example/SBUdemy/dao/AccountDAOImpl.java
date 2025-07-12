package com.example.SBUdemy.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {

        System.out.println(getClass() + "Doing my db work : Add an account");

    }


}

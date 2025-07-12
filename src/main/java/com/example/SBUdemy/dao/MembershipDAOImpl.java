package com.example.SBUdemy.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addMember() {

        System.out.println(getClass() + "Doing my db work : Add a membership account");
        return true;
    }


}

package com.example.SBUdemy.dao;

import com.example.SBUdemy.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
}

package com.itheima.dao;

import com.itheima.damain.User;

import java.util.List;

public interface UserDao {
    List<User>findAll();

    List<User> findByName(String username);
}

package com.jiejie.dao;

import com.jiejie.domain.User;

import java.util.List;

public interface UserDao {

    User findByUsername(String username);

    List<User> findAll();

    void save(User user);

    User findById(String id);

    List<User> findByIdOtherRole(String id);
}

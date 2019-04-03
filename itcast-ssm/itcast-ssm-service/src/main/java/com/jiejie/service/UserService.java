package com.jiejie.service;

import com.jiejie.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    void save(User user);

    User findById(String id);
}

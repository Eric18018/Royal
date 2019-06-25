package com.bbs.service;

import com.bbs.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    List<User>findByUsername(String userName);
}

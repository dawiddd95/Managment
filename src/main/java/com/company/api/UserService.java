package com.company.api;

import com.company.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(User user);
    void removeUserById(Long userId);
}

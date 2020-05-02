package com.company.api;

import com.company.entity.User;

public interface UserRegisterLoginFacade {
    boolean registerUser(User user);
    boolean loginUser(String login, String password);
}

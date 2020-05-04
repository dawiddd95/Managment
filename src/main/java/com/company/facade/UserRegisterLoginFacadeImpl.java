package com.company.facade;

import com.company.api.UserRegisterLoginFacade;
import com.company.api.UserService;
import com.company.entity.User;
import com.company.service.UserServiceImpl;


public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {
    private UserService userService = UserServiceImpl.getInstance();
    private static UserRegisterLoginFacade instance = null;

    private UserRegisterLoginFacadeImpl() {

    }

    public static UserRegisterLoginFacade getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    public boolean registerUser(User user) {
        return userService.addUser(user);
    }

    public boolean loginUser(String login, String password) {
        if (userService.isCorrectLoginAndPassword(login, password)) {
            return true;
        }

        return false;
    }


}

package com.company.validator;

import com.company.api.UserDao;
import com.company.dao.UserDaoImpl;
import com.company.entity.User;
import com.company.exception.UserLoginAlreadyExistException;
import com.company.exception.UserShortLengthLoginException;
import com.company.exception.UserShortLengthPasswordException;

import java.io.IOException;

public class UserValidator {
    private final int MIN_LENGTH_PASSWORD = 6;
    private final int MIN_LENGTH_LOGIN = 4;

    private static UserValidator instance = null;

    private UserValidator() {

    }

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }

        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException {
        if (isPasswordLengthNoEnough(user.getPassword()))
            throw new UserShortLengthPasswordException("Password is too short.");

        if (isLoginLengthNoEnough(user.getLogin()))
            throw new UserShortLengthLoginException("Login is too short.");

        return true;
    }

    private boolean isPasswordLengthNoEnough(String password) {
        return password.length() < MIN_LENGTH_PASSWORD;
    }

    private boolean isLoginLengthNoEnough(String login) {
        return login.length() < MIN_LENGTH_LOGIN;
    }
}

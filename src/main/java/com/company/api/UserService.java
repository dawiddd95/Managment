package com.company.api;

import com.company.entity.User;
import com.company.exception.UserLoginAlreadyExistException;
import com.company.exception.UserShortLengthLoginException;
import com.company.exception.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public interface UserService {
    boolean addUser(User user);

    void removeUserById(Long userId) throws IOException;

    List<User> getAllUsers() throws IOException;
    User getUserById(Long userId) throws IOException;
    User getUserByLogin(String login) throws IOException;

    boolean isCorrectLoginAndPassword(String login, String password);
}

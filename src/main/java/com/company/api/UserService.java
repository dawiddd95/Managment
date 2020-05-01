package com.company.api;

import com.company.entity.User;
import com.company.exception.UserLoginAlreadyExistException;
import com.company.exception.UserShortLengthLoginException;
import com.company.exception.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers() throws IOException;
    void addUser(User user) throws IOException, UserShortLengthPasswordException, UserLoginAlreadyExistException, UserShortLengthLoginException;
    void removeUserById(Long userId) throws IOException;
}

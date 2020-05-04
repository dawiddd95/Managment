package com.company.api;

import com.company.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    boolean addUser(User user);

    List<User> getAllUsers() throws IOException;
    User getUserByLogin(String login) throws IOException;

    boolean isCorrectLoginAndPassword(String login, String password);
}

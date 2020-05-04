package com.company.dao;

import com.company.api.UserDao;
import com.company.entity.User;
import com.company.entity.parser.UserParser;
import com.company.utils.FileUtils;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final static UserDao instance = new UserDaoImpl();

    private Connection connection;
    private final String databaseName = "people";
    private final String tableName = "users";
    private final String user = "postgres";
    private final String password = "m2svs4";

    private UserDaoImpl() {
        init();
    }

    public static UserDao getInstance() {
        return UserDaoImpl.instance;
    }

    private void init() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/"+databaseName+"?useSSL=false", user, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new LinkedList<User>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                User user = new User(id, login, password);
                users.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void saveUser(User user) {
        PreparedStatement statement;
        try {
            String query = "insert into " + tableName + " (login, password) values(?, ?)";
            statement = connection.prepareStatement(query);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

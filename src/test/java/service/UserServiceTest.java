package service;

import com.company.entity.User;
import com.company.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Test
    public void testGetUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User(1L, "admin", "admin"));
        users.add(new User(2L, "pablo", "admin"));

        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> usersFromTestingClass = userService.getUsers();

        Assert.assertEquals(users, usersFromTestingClass);
    }

    @Test
    public void testAddUser() {
        List<User> users = new ArrayList<User>();
        User user = new User(1L, "admin", "admin");
        users.add(user);

        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);

        List<User> usersFromTestingClass = userService.getUsers();

        Assert.assertEquals(users, usersFromTestingClass);
    }

    @Test
    public void testDeleteUser() {
        List<User> users = new ArrayList<User>();
        User admin = new User(1L, "admin", "admin");
        User pablo = new User(2L, "pablo", "admin");
        users.add(admin);
        users.add(pablo);

        UserServiceImpl userService = new UserServiceImpl(users);

        users.remove(admin);
        userService.removeUserById(1L);

        List<User> usersFromTestingClass = userService.getUsers();

        Assert.assertEquals(users, usersFromTestingClass);
    }

}

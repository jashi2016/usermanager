package com.kiran.User.Service;

import com.kiran.User.Entity.User;

import java.util.List;

public interface UserInt {
    User addUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    User updateUserById(int id, String userName);

    User deleteUserById(int id);
}

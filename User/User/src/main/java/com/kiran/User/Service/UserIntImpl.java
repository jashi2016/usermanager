package com.kiran.User.Service;

import com.kiran.User.Entity.User;
import com.kiran.User.Exception.UserCustomExceptionFound;
import com.kiran.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserIntImpl implements UserInt{

    @Autowired
    UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users=  userRepository.findAll();
        return users;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    @ResponseBody
    public User updateUserById(int id, String userName) {
        User user = userRepository.findById(id).get();
        user.setUsername(userName);
        userRepository.save(user);
        return user;
    }

    @Override
    @ResponseBody
    public User deleteUserById(int id) {
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return user;
    }
}

package com.springapp.service;

import com.springapp.model.User;

import java.util.List;


public interface UserService {

    public void updateUser(User user);

    public User getUserById(int id);

    public List<User> listUsers();

    public List<User> getAllUsers();
}

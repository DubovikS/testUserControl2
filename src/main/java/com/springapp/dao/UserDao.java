package com.springapp.dao;


import com.springapp.model.User;

import java.util.List;

public interface UserDao {

    public void updateUser(User user);

    public User getUserById(int id);

    public List<User> listUsers();

    public List<User> getAllUsers();
}

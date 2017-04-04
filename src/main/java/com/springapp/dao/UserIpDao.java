package com.springapp.dao;


import com.springapp.model.UserIp;

import java.util.List;


public interface UserIpDao {

    public void updateUser(UserIp user);

    public List<UserIp> getAllUsers();
}

package com.springapp.service;


import com.springapp.model.UserIp;

import java.util.List;

public interface UserIpService {

    public void updateUser(UserIp user);

    public List<UserIp> getAllUsers();
}

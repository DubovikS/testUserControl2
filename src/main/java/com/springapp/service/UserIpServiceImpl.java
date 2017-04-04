package com.springapp.service;


import com.springapp.dao.UserIpDao;
import com.springapp.model.UserIp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserIpServiceImpl implements UserIpService{

    private UserIpDao userDao;

    public UserIpDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserIpDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void updateUser(UserIp user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public List<UserIp> getAllUsers() {
        return this.userDao.getAllUsers();
    }
}

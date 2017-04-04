package com.springapp.dao;

import com.springapp.model.UserIp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserIpImpl implements UserIpDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    @Override
    public void updateUser(UserIp user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
        //session.update(user);
    }

    @Override
    public List<UserIp> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserIp> userList = session.createQuery("from User").list();

        return userList;
    }
}

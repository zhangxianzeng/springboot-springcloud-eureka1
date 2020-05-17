package com.example.demoshengchanzhe.service;

import com.example.demoshengchanzhe.dao.UserDao;
import com.example.demoshengchanzhe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAlluser() {
        return userDao.findAlluser();
    }

    @Override
    public int save(User user) {
        return userDao.save(user.getUsername(),user.getPassword());
    }

    @Override
    public List<User> findAlluserbyname(String username) {
        return userDao.findAlluserbyname(username);
    }

    @Override
    public int delete(String username) {
        return userDao.delete(username);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }
}

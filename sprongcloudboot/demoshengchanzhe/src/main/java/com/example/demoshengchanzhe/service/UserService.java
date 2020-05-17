package com.example.demoshengchanzhe.service;

import com.example.demoshengchanzhe.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    List<User> findAlluser();
    public int save(User user);
    List<User> findAlluserbyname(String username);
    public int delete(String username);
    public int update(User user);
}

package com.example.demoshengchanzhe.dao;

import com.example.demoshengchanzhe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserDao {
    List<User> findAlluser();
    public int save(String username,String password);
    List<User> findAlluserbyname(@Param("username") String username);
    public int delete(@Param("username") String username);
    public int update(User user);
}

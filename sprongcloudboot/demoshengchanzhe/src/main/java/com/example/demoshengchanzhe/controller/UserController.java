package com.example.demoshengchanzhe.controller;

import com.example.demoshengchanzhe.pojo.User;
import com.example.demoshengchanzhe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/a")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/b")
    public List<User> find(){
        return userService.findAlluser();
    }
    //数据写在路径上
//    @RequestMapping(value = "/save/{username}/{password}",method = RequestMethod.POST)
//
//    public int save(@PathVariable String username,@PathVariable String password,User user){
//        return userService.save(user);
//    }
    @RequestMapping(value = "/save2",method = RequestMethod.POST)
    public int save(User user){
        return userService.save(user);
    }

//    @RequestMapping(value = "/findbyname/{username}",method = RequestMethod.POST)
//    public List<User> findallbyname(@PathVariable String username){
//        return userService.findAlluserbyname(username);
//    }

    @RequestMapping(value = "/findbyname",method = RequestMethod.POST)
    public List<User> findallbyname(String username){
        return userService.findAlluserbyname(username);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public int delete(String username){
        return userService.delete(username);
    }
    @RequestMapping(value = "/updata",method = RequestMethod.POST)
    public int update(User user){
        return userService.update(user);
    }
}

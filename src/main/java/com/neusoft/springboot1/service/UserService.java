package com.neusoft.springboot1.service;

import com.neusoft.springboot1.entity.User;
import com.neusoft.springboot1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser(){
        List<User> users = userMapper.getAllUser();
        return users;
    }

    public int updateUserStatus(Integer status,  Integer uId){
        return userMapper.updateUserStatus(status,uId);
    }
}

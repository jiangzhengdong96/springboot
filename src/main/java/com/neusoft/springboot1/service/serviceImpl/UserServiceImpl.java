package com.neusoft.springboot1.service.serviceImpl;

import com.neusoft.springboot1.entity.User;
import com.neusoft.springboot1.mapper.UserMapper;
import com.neusoft.springboot1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer uId) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userMapper.getAllUser();
        return users;
    }

    @Override
    public int deleteUserById(Integer uId) {
        return 0;
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserStatus(Integer status, Integer uId) {
        return userMapper.updateUserStatus(status,uId);
    }

    @Override
    public User getUserByuName(String uName) {
        return userMapper.getUserByuName(uName);
    }

    @Override
    public int updateUserPassword(User user) {
        return userMapper.updateUserPassword(user);
    }


}

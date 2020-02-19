package com.neusoft.springboot1.service;

import com.neusoft.springboot1.entity.Manager;
import com.neusoft.springboot1.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    public Manager managerLogin(String mName){
        Manager manager = managerMapper.managerLogin(mName);
        return manager;
    }
}

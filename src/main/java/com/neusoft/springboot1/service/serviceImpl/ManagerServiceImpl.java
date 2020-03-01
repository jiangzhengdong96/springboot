package com.neusoft.springboot1.service.serviceImpl;

import com.neusoft.springboot1.entity.Manager;
import com.neusoft.springboot1.mapper.ManagerMapper;
import com.neusoft.springboot1.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Manager managerLogin(String mName) {
        Manager manager = managerMapper.managerLogin(mName);
        return manager;
    }


}

package com.neusoft.springboot1.service.serviceImpl;

import com.neusoft.springboot1.entity.Type;
import com.neusoft.springboot1.mapper.TypeMapper;
import com.neusoft.springboot1.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> getAllType() {
        List<Type> types = typeMapper.getAllType();
        return types;
    }

    @Override
    public List<Type> getAllType1() {
        return typeMapper.getAllType1();
    }

    @Override
    public List<Type> getTypeByName(String tName) {
        return typeMapper.getTypeByName(tName);
    }

    @Override
    public Type getTypeById(Integer tId) {
        return typeMapper.getTypeById(tId);
    }

    @Override
    public int insertType(Type type) {
        return typeMapper.insertType(type);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public int updateTypeStatus(Integer status, Integer tId) {
        return typeMapper.updateTypeStatus(status,tId);
    }

    @Override
    public int insertType1(Type type) {
        return typeMapper.insertType1(type);
    }


}

package com.neusoft.springboot1.service;

import com.neusoft.springboot1.entity.Type;
import com.neusoft.springboot1.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public List<Type> getAllType(){
        List<Type> types = typeMapper.getAllType();
        return types;
    }

//    public int deleteTypeById(Integer id){
//        return typeMapper.deleteTypeById(id);
//    }
    public List<Type> getTypeByName(String tName){
        return typeMapper.getTypeByName(tName);
    }

    public int updateType(Type type){
        return typeMapper.updateType(type);
    }

    public int insertType(Type type){
        return typeMapper.insertType(type);
    }

    public int updateTypeStatus(Integer status,Integer tId){
        return typeMapper.updateTypeStatus(status,tId);
    }

    public Type getTypeById(Integer tId){
        return typeMapper.getTypeById(tId);
    }
}

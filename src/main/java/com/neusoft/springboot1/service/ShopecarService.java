package com.neusoft.springboot1.service;

import com.neusoft.springboot1.entity.Shopcar;
import com.neusoft.springboot1.mapper.ShopecarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopecarService {
    @Autowired
    private ShopecarMapper shopecarMapper;

    public List<Shopcar> getAllShopcar(){
        List<Shopcar> shopcars = shopecarMapper.getAllShopcar();
        return shopcars;
    }

    public List<Shopcar> getShopcarById(Integer uId){
        List<Shopcar> shopcars = shopecarMapper.getShopcarById(uId);
        return shopcars;
    }

}

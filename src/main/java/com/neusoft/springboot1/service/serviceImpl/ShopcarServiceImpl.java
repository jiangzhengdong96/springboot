package com.neusoft.springboot1.service.serviceImpl;

import com.neusoft.springboot1.entity.Shopcar;
import com.neusoft.springboot1.mapper.ShopecarMapper;
import com.neusoft.springboot1.service.ShopcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopcarServiceImpl implements ShopcarService {
    @Autowired
    private ShopecarMapper shopecarMapper;

    @Override
    public int updateShopcarStatus(Integer status, Integer sId) {
        return shopecarMapper.updateShopcarStatus(status,sId);
    }

    @Override
    public List<Shopcar> getShopcarById(Integer uId) {
        List<Shopcar> shopcars = shopecarMapper.getShopcarById(uId);
        return shopcars;
    }

    @Override
    public List<Shopcar> getAllShopcar() {
        List<Shopcar> shopcars = shopecarMapper.getAllShopcar();
        return shopcars;
    }


}

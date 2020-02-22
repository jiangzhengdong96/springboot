package com.neusoft.springboot1.service;

import com.neusoft.springboot1.entity.OrderGoods;
import com.neusoft.springboot1.mapper.OrderGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderGoodsService {
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    public List<OrderGoods> getAllOrderGoodsById(Integer oId){
        List<OrderGoods> orderGoods = orderGoodsMapper.getAllOrderGoodsById(oId);
        return orderGoods;
    }
}

package com.neusoft.springboot1.service.serviceImpl;

import com.neusoft.springboot1.entity.OrderGoods;
import com.neusoft.springboot1.mapper.OrderGoodsMapper;
import com.neusoft.springboot1.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Override
    public List<OrderGoods> getAllOrderGoodsById(Integer oId) {
        List<OrderGoods> orderGoods = orderGoodsMapper.getAllOrderGoodsById(oId);
        return orderGoods;
    }

    @Override
    public int updateOrderGoodsStatus(Integer status, Integer id) {
        return orderGoodsMapper.updateOrderGoodsStatus(status,id);
    }


}

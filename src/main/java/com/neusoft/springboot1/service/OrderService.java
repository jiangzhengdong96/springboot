package com.neusoft.springboot1.service;

import com.neusoft.springboot1.entity.Order;
import com.neusoft.springboot1.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getAllOrder(){
        List<Order> orders = orderMapper.getAllOrder();
        return orders;
    }
}

package com.neusoft.springboot1.service.serviceImpl;

import com.neusoft.springboot1.entity.Order;
import com.neusoft.springboot1.mapper.OrderMapper;
import com.neusoft.springboot1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int updateOrderStatus(Integer status, Integer oId) {
        return orderMapper.updateOrderStatus(status,oId);
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> orders = orderMapper.getAllOrder();
        return orders;
    }


}

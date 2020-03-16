package com.neusoft.springboot1.service.serviceImpl;

import com.neusoft.springboot1.entity.Order;
import com.neusoft.springboot1.mapper.OrderMapper;
import com.neusoft.springboot1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    @Override
    public Order getLastOrder() {
        return orderMapper.getLastOrder();
    }

    @Override
    public int updateOrderisPay(Integer isPay, Timestamp paytime, Integer oId) {
        return orderMapper.updateOrderisPay(isPay,paytime,oId);
    }

    @Override
    public int updateOrderisSend(Integer isSend, Timestamp sendtime, Integer oId, String sendNumber) {
        return orderMapper.updateOrderisSend(isSend,sendtime,oId,sendNumber);
    }


    @Override
    public int updateOrderisReceipt(Integer isReceipt, Timestamp receipttime, Integer oId) {
        return orderMapper.updateOrderisReceipt(isReceipt,receipttime,oId);
    }

    @Override
    public int deleteOrderById(Integer oId) {
        return orderMapper.deleteOrderById(oId);
    }


}

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

    @Override
    public int insertOrderGoods(OrderGoods orderGoods) {
        return orderGoodsMapper.insertOrderGoods(orderGoods);
    }

    @Override
    public List<OrderGoods> getAllOrder(Integer uId) {
        return orderGoodsMapper.getAllOrder(uId);
    }

    @Override
    public List<OrderGoods> getOrdersByIs(Integer uId, Integer isPay, Integer isSend, Integer isReceipt, Integer isComment) {
        return orderGoodsMapper.getOrdersByIs(uId,isPay,isSend,isReceipt,isComment);
    }

    @Override
    public OrderGoods getOrderInfo(Integer id) {
        return orderGoodsMapper.getOrderInfo(id);
    }

    @Override
    public int updateOrderGoodsIsCommented(Integer isCommented, Integer id) {
        return orderGoodsMapper.updateOrderGoodsIsCommented(isCommented,id);
    }

    @Override
    public int updateOrderGoodsIsDeal(Integer isDeal, Integer id) {
        return orderGoodsMapper.updateOrderGoodsIsDeal(isDeal,id);
    }

    @Override
    public int deleteOrderGoodsById(Integer id) {
        return orderGoodsMapper.deleteOrderGoodsById(id);
    }

    @Override
    public List<OrderGoods> getAllOrderBygId(Integer gId) {
        return orderGoodsMapper.getAllOrderBygId(gId);
    }


}

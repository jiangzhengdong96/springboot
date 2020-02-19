package com.neusoft.springboot1.service;

import com.neusoft.springboot1.entity.Goods;
import com.neusoft.springboot1.entity.Type;
import com.neusoft.springboot1.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> getAllGoods(){
        List<Goods> goods = goodsMapper.getAllGoods();
        return goods;
    }
}

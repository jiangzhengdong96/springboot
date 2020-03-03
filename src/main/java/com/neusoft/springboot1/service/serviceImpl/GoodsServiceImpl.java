package com.neusoft.springboot1.service.serviceImpl;

import com.neusoft.springboot1.entity.Goods;
import com.neusoft.springboot1.mapper.GoodsMapper;
import com.neusoft.springboot1.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getAllGoods() {
        List<Goods> goods = goodsMapper.getAllGoods();
        return goods;
    }

    @Override
    public List<Goods> getAllGoods1() {
        List<Goods> goods = goodsMapper.getAllGoods1();
        return goods;
    }

    @Override
    public int updateGoodStatus(Integer gStatus, Integer gId) {
        return goodsMapper.updateGoodStatus(gStatus,gId);
    }

    @Override
    public Goods getGoodsInfoById(Integer gId) {
        return goodsMapper.getGoodsInfoById(gId);
    }


}

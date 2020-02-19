package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.Goods;
import com.neusoft.springboot1.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsMapper {


    @Select("select goods.g_id,goods.g_name,goods.g_intro,goods.g_num,goods.g_pic,goods.g_status,goods.addtime," +
            "goods.g_price,user.u_name,type.t_name from goods left join user" +
            " on goods.u_id=user.u_id left join type on goods.t_id=type.t_id")
    List<Goods> getAllGoods();
    //是否使用自动生成的组件，以及那个属性是用来封装组件的

}

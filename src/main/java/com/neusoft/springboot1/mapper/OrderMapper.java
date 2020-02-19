package com.neusoft.springboot1.mapper;


import com.neusoft.springboot1.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface OrderMapper {

    @Select("select order.o_id,order.o_name,order.status,order.payment," +
            "order.addtime,order.price,user.u_name,goods.g_name,user.address from `order` " +
            "left join user on order.u_id=user.u_id left join goods on order.g_id=goods.g_id")
//    @Select("select * from `order`")
    List<Order> getAllOrder();
//    select order.o_id,order.o_name,order.status,order.payment,order.addtime,order.price,user.u_name,goods.g_name,user.address from `order` left join user on order.u_id=user.u_id left join goods on order.g_id=goods.g_id
}

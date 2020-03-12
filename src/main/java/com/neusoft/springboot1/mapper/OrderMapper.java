package com.neusoft.springboot1.mapper;


import com.neusoft.springboot1.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
public interface OrderMapper {

    @Select("select order.o_id,order.o_name,order.status,order.payment," +
            "order.addtime,order.price,user.u_name,order.address,order.is_pay," +
            "order.paytime,order.is_send,order.sendtime,order.is_receipt,order.receipttime,order.send_number from `order` " +
            "left join user on order.u_id=user.u_id")
//    @Select("select * from `order`")
    List<Order> getAllOrder();
//    select order.o_id,order.o_name,order.status,order.payment,order.addtime,order.price,user.u_name,goods.g_name,user.address from `order` left join user on order.u_id=user.u_id left join goods on order.g_id=goods.g_id
    @Update("update `order` set status=#{status} where o_id =#{oId}")
    int updateOrderStatus(@Param("status") Integer status, @Param("oId") Integer oId);
}

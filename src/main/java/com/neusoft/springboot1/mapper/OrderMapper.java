package com.neusoft.springboot1.mapper;


import com.neusoft.springboot1.entity.Order;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;
public interface OrderMapper {

    @Select("select order.o_id,order.o_name,order.o_status,order.payment,order.addtime,order.price,user.u_name,order.address,order.is_pay,order.paytime,order.is_send,order.sendtime,order.is_receipt,order.receipttime,order.send_number from `order` " +
            "left join user on order.u_id=user.u_id")
//    @Select("select * from `order`")
    List<Order> getAllOrder();
    @Select(" select * from `order` order by o_id desc limit 0,1")
//    @Select("select * from `order`")
    Order getLastOrder();
//    select order.o_id,order.o_name,order.status,order.payment,order.addtime,order.price,user.u_name,goods.g_name,user.address from `order` left join user on order.u_id=user.u_id left join goods on order.g_id=goods.g_id
    @Update("update `order` set o_status=#{status} where o_id =#{oId}")
    int updateOrderStatus(@Param("status") Integer status, @Param("oId") Integer oId);

    @Update("update `order` set is_pay=#{isPay},paytime=#{paytime} where o_id =#{oId}")
    int updateOrderisPay(@Param("isPay") Integer isPay, @Param("paytime") Timestamp paytime, @Param("oId") Integer oId);
//    select * from 'order' by o_id desc limit 0,1;
    @Update("update `order` set is_send=#{isSend},sendtime=#{sendtime},send_number=#{sendNumber} where o_id =#{oId}")
    int updateOrderisSend(@Param("isSend") Integer isSend, @Param("sendtime") Timestamp sendtime, @Param("oId") Integer oId,@Param("sendNumber") String sendNumber);
    @Update("update `order` set is_receipt=#{isReceipt},receipttime=#{receipttime} where o_id =#{oId}")
    int updateOrderisReceipt(@Param("isReceipt") Integer isReceipt, @Param("receipttime") Timestamp receipttime, @Param("oId") Integer oId);

    @Options(useGeneratedKeys = true,keyProperty = "oId")
    @Insert("insert into `order` (o_name,addtime,u_id,price,address,payment,is_pay,paytime) values(#{oName},#{addtime},#{uId},#{price},#{address},#{payment},#{isPay},#{paytime})")
    int insertOrder(Order order);

    @Delete("delete from `order` where o_id=#{oId}")
    int deleteOrderById(Integer oId);
}

package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.OrderGoods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderGoodsMapper {

    @Select("select s.id,s.num,s.status,s.addtime,,s.is_deal,s.updatetime,g.g_name,g.g_price from order_goods s left join goods g on s.g_id=g.g_id where s.o_id=#{oId}")
//    @Select("select * from `order`")
    List<OrderGoods> getAllOrderGoodsById(Integer oId);
    @Select("select s.id,s.num,s.status,s.addtime,s.updatetime,s.is_deal,g.g_name,g.g_pic,g.g_price,g.g_id,s.is_commented,s.o_id,o.u_id,o.o_name,o.o_status,o.payment,o.addtime,o.price,o.address,o.is_pay,o.paytime,o.is_send,o.sendtime,o.is_receipt,o.receipttime,o.send_number from order_goods s left join goods g on s.g_id=g.g_id left join `order` o on s.o_id=o.o_id where s.status = 1 and o.o_status = 1 and s.id =#{id}")
    OrderGoods getOrderInfo(Integer id);

    @Select("select s.id,s.num,s.status,s.addtime,s.updatetime,s.is_deal,g.g_name,g.g_pic,g.g_price,g.g_id,g.g_status,s.is_commented,s.o_id,o.u_id,o.o_name,o.o_status,o.payment,o.addtime,o.price,o.address,o.is_pay,o.paytime,o.is_send,o.sendtime,o.is_receipt,o.receipttime,o.send_number from order_goods s left join goods g on s.g_id=g.g_id left join `order` o on s.o_id=o.o_id where s.status = 1 and o.o_status = 1 and o.u_id =#{uId}")
    List<OrderGoods> getAllOrder(Integer uId);
    @Select("select s.id,s.num,s.status,s.addtime,u.u_name,u.tele,s.updatetime,s.is_deal,g.g_name,g.g_pic,g.g_status,g.g_price,g.g_id,s.is_commented,s.o_id,o.u_id,o.o_name,o.o_status,o.payment,o.addtime,o.price,o.address,o.is_pay,o.paytime,o.is_send,o.sendtime,o.is_receipt,o.receipttime,o.send_number from order_goods s left join goods g on s.g_id=g.g_id left join `order` o on s.o_id=o.o_id left join user u on o.u_id=u.u_id where s.status = 1 and o.o_status = 1 and s.g_id =#{gId}")
    List<OrderGoods> getAllOrderBygId(Integer gId);
    @Select("select s.id,s.num,s.status,s.addtime,s.updatetime,s.is_deal,g.g_name,g.g_pic,g.g_price,g.g_id,g.g_status,s.is_commented,s.o_id,o.u_id,o.o_name," +
            "o.o_status,o.payment,o.addtime,o.price,o.address,o.is_pay,o.paytime,o.is_send,o.sendtime,o.is_receipt,o.receipttime,o.send_number from order_goods s left join goods g on s.g_id=g.g_id left join `order` o " +
            "on s.o_id=o.o_id where s.status = 1 and o.o_status = 1 and o.u_id =#{uId} and o.is_pay =#{isPay} and o.is_send =#{isSend} and o.is_Receipt =#{isReceipt} and s.is_commented =#{isCommented} and s.is_deal = 1")
    List<OrderGoods> getOrdersByIs(@Param("uId") Integer uId, @Param("isPay") Integer isPay,@Param("isSend") Integer isSend,@Param("isReceipt") Integer isReceipt,@Param("isCommented") Integer isComment);
    @Update("update order_goods set status=#{status} where id =#{id}")
    int updateOrderGoodsStatus(@Param("status") Integer status, @Param("id") Integer id);

    @Update("update order_goods set is_commented=#{isCommented} where id =#{id}")
    int updateOrderGoodsIsCommented(@Param("isCommented") Integer isCommented, @Param("id") Integer id);

    @Update("update order_goods set is_deal=#{isDeal} where id =#{id}")
    int updateOrderGoodsIsDeal(@Param("isDeal") Integer isDeal, @Param("id") Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into order_goods(o_id,g_id,addtime,updatetime,num) values(#{oId},#{gId},#{addtime},#{updatetime},#{num})")
    int insertOrderGoods(OrderGoods orderGoods);

    @Delete("delete from order_goods where id=#{id}")
    int deleteOrderGoodsById(Integer id);
}

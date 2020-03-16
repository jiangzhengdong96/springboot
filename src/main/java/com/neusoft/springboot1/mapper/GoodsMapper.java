package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsMapper {


    @Select("select goods.g_id,goods.up_status,goods.g_name,goods.g_intro,goods.g_num,goods.g_pic,goods.g_status,goods.addtime," +
            "goods.g_price,user.u_name,type.t_name from goods left join user" +
            " on goods.u_id=user.u_id left join type on goods.t_id=type.t_id")
    List<Goods> getAllGoods();
    @Select("select goods.g_id,goods.g_name,goods.g_intro,goods.g_num,goods.g_pic,goods.g_status,goods.addtime," +
            "goods.g_price,user.u_name,type.t_name from goods left join user" +
            " on goods.u_id=user.u_id left join type on goods.t_id=type.t_id where goods.g_status = 1  and goods.up_status = 1 and goods.is_delete = 0")
    List<Goods> getAllGoods1();
    @Select("select goods.g_id,goods.g_name,goods.g_intro,goods.g_num,goods.g_pic,goods.g_status,goods.addtime," +
            "goods.g_price,user.u_name,type.t_name from goods left join user" +
            " on goods.u_id=user.u_id left join type on goods.t_id=type.t_id where goods.g_status = 1 and goods.t_id = #{tId}   and goods.up_status = 1 and goods.is_delete = 0")
    List<Goods> getGoodsBytId(Integer tId);
    @Select("select goods.g_id,goods.up_status,goods.g_name,goods.is_delete,goods.g_intro,goods.g_num,goods.g_pic,goods.g_status,goods.addtime," +
            "goods.g_price,user.u_name,type.t_name from goods left join user" +
            " on goods.u_id=user.u_id left join type on goods.t_id=type.t_id where  goods.u_id = #{uId} and goods.is_delete = 0")
    List<Goods> getGoodsByuId(Integer uId);
    @Select("select goods.g_id,goods.up_status,goods.g_name,goods.is_delete,goods.g_intro,goods.g_num,goods.g_pic,goods.g_status,goods.addtime," +
            "goods.g_price,user.u_name,type.t_name from goods left join user" +
            " on goods.u_id=user.u_id left join type on goods.t_id=type.t_id where  goods.u_id = #{uId}")
    List<Goods> getGoodsByuId1(Integer uId);
    @Select("select goods.g_id,goods.g_name,goods.g_intro,goods.g_num,goods.g_pic,goods.g_status,goods.addtime," +
            "goods.g_price,user.u_name,type.t_name from goods left join user" +
            " on goods.u_id=user.u_id left join type on goods.t_id=type.t_id where goods.g_status = 1 and goods.is_delete = 0 and goods.up_status = 1 and goods.g_name like '%${search}%'")
    List<Goods> getGoodsBySearch(String search);
    //是否使用自动生成的组件，以及那个属性是用来封装组件的
    @Select("select goods.g_id,goods.g_name,goods.g_intro,goods.t_id,goods.g_num,goods.u_id,goods.g_pic,goods.g_status,goods.addtime,goods.collectt," +
            "goods.g_price,user.u_name,type.t_name from goods left join user" +
            " on goods.u_id=user.u_id left join type on goods.t_id=type.t_id where goods.g_id = #{gId}")
    Goods getGoodsInfoById(Integer gId);
    @Select("select goods.g_id,goods.g_name,goods.g_intro,goods.g_num,goods.g_pic,goods.g_status,goods.addtime," +
            "goods.g_price,user.u_name,type.t_name from goods left join user" +
            " on goods.u_id=user.u_id left join type on goods.t_id=type.t_id where goods.g_name = #{gName}")
    List<Goods> getGoodsInfoBygName(String gName);
    @Update("update goods set g_status=#{gStatus} where g_id =#{gId}")
    int updateGoodStatus(@Param("gStatus") Integer gStatus, @Param("gId") Integer gId);
    @Update("update goods set up_status=#{upStatus} where g_id =#{gId}")
    int updateGoodupStatus(@Param("upStatus") Integer upStatus, @Param("gId") Integer gId);
    @Update("update goods set is_delete=#{isDelete} where g_id =#{gId}")
    int updateGoodisDelete(@Param("isDelete") Integer isDelete, @Param("gId") Integer gId);
    @Options(useGeneratedKeys = true,keyProperty = "gId")
    @Insert("insert into goods(g_name,g_intro,g_num,u_id,g_pic,addtime,g_price,t_id) values(#{gName},#{gIntro},#{gNum},#{uId},#{gPic},#{addtime},#{gPrice},#{tId})")
    int insertGoods(Goods goods);
    @Update("update goods  set g_name=#{gName},g_intro=#{gIntro},g_num=#{gNum},g_pic=#{gPic},g_price=#{gPrice},t_id=#{tId} where g_id = #{gId}")
    int updateGoods(Goods goods);
    @Update("update goods  set g_num=#{gNum} where g_id = #{gId}")
    int updateGoodsNum(@Param("gId") Integer gId,@Param("gNum") Integer gNum);

}

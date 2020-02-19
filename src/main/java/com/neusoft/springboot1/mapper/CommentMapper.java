package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.Comment;
import com.neusoft.springboot1.entity.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper {
    @Select("select comment.c_id,comment.c_intro,comment.status,comment.addtime,user.u_name,goods.g_name from comment left join `order` on comment.o_id=order.o_id left join user on order.u_id=user.u_id left join goods on order.g_id=goods.g_id")
    List<Comment> getAllComment();
//    //是否使用自动生成的组件，以及那个属性是用来封装组件的
}

package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentMapper {
    @Select("select comment.c_id,comment.c_intro,comment.status,comment.addtime,user.u_name,goods.g_name from comment left join goods on comment.g_id=goods.g_id left join user on comment.u_id=user.u_id ")
    List<Comment> getAllComment();
//    //是否使用自动生成的组件，以及那个属性是用来封装组件的
    @Select("select comment.c_id,comment.c_intro,comment.status,comment.addtime,user.u_name,user.u_pic,goods.g_name from comment left join goods on comment.g_id=goods.g_id left join user on comment.u_id=user.u_id where comment.g_id = #{gId}")
    List<Comment> getAllCommentsById(Integer gId);
    @Update("update comment set status=#{status} where c_id =#{cId}")
    int updateCommentStatus(@Param("status") Integer status, @Param("cId") Integer cId);
}

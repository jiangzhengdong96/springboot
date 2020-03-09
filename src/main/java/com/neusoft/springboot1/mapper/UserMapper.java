package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where u_id=#{uId}")
    User getUserById(Integer uId);
    @Select("select * from user where u_name=#{uName}")
    User getUserByuName(String uName);
    @Select("select * from user")
    List<User> getAllUser();
    @Delete("delete from user where u_id=#{uId}")
    int deleteUserById(Integer uId);
    //是否使用自动生成的组件，以及那个属性是用来封装组件的
    @Options(useGeneratedKeys = true,keyProperty = "uId")
    @Insert("insert into user(u_name,password,email,tele,addtime) values(#{uName},#{password},#{email},#{tele},#{addtime})")
    int insertUser(User user);
    @Update("update user set u_name=#{uName}, email=#{email}, tele=#{tele}, address=#{address}, intro=#{intro}, u_pic=#{uPic}, sex=#{sex} where u_id =#{uId}")
    int updateUser(User user);
    @Update("update user set u_name=#{uName}, email=#{email}, tele=#{tele}, address=#{address}, intro=#{intro}, sex=#{sex}, u_pic=#{uPic} where u_id =#{uId}")
    int updateUserInfo(User user);
    @Update("update user set password=#{password} where u_name =#{uName}")
    int updateUserPassword(User user);

    @Update("update user set status=#{status} where u_id =#{uId}")
    int updateUserStatus(@Param("status") Integer status, @Param("uId") Integer uId);
}

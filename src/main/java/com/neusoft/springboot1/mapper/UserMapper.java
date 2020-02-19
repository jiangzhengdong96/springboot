package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where u_id=#{uId}")
    User getUserById(Integer uId);
    @Select("select * from user")
    List<User> getAllUser();
    @Delete("delete from user where u_id=#{uId}")
    int deleteUserById(Integer uId);
    //是否使用自动生成的组件，以及那个属性是用来封装组件的
    @Options(useGeneratedKeys = true,keyProperty = "uId")
    @Insert("insert into user(u_name,password,email,tele,address,intro,u_pic,sex) values(#{uName},#{password},#{email},#{tele},#{address},#{intro},#{uPic},#{sex})")
    int insertUser(User user);
    @Update("update user set u_name=#{uName}, email=#{email}, tele=#{tele}, address=#{address}, intro=#{intro}, u_pic=#{uPic}, sex=#{sex} where u_id =#{uId}")
    int updateUser(User user);
}
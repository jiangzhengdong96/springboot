package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.Type;
import com.neusoft.springboot1.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TypeMapper {


    @Select("select * from type")
    List<Type> getAllType();
    @Delete("delete from type where t_id=#{tId}")
    int deleteTypeById(Integer tId);
    @Options(useGeneratedKeys = true,keyProperty = "tId")
    @Insert("insert into type(t_name,addtime) values(#{tName},#{addtime})")
    int insertType(Type type);
    @Update("update type set t_name=#{tName} where t_id =#{tId}")
    int updateType(Type type);
}

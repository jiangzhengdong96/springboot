package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TypeMapper {


    @Select("select * from type")
    List<Type> getAllType();
    @Select("select * from type where type.status = 1")
    List<Type> getAllType1();
    @Select("select * from type where t_name=#{tName}")
    List<Type> getTypeByName(String tName);
    @Select("select * from type where t_id=#{tId}")
    Type getTypeById(Integer tId);
//    @Delete("delete from type where t_id=#{tId}")
//    int deleteTypeById(Integer tId);
    @Options(useGeneratedKeys = true,keyProperty = "tId")
    @Insert("insert into type(t_name,addtime) values(#{tName},#{addtime})")
    int insertType(Type type);

    @Options(useGeneratedKeys = true,keyProperty = "tId")
    @Insert("insert into type(t_name) values(#{tName})")
    int insertType1(Type type);
    @Update("update type set t_name=#{tName},updatetime=#{updatetime}  where t_id =#{tId}")
    int updateType(Type type);
    @Update("update type set status=#{status} where t_id =#{tId}")
    int updateTypeStatus(@Param("status") Integer status,@Param("tId") Integer tId);
}

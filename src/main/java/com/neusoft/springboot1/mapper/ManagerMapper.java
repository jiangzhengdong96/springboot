package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

//@Param("mName")  多参数传入的时候必须写


public interface ManagerMapper {
    @Select("select * from manage where m_name=#{mName}")
    Manager managerLogin(@Param("mName") String mName);
}

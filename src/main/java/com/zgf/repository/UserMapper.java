package com.zgf.repository;

import com.zgf.dto.StudentDto;
import com.zgf.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    //登录校验
    @Select("select * from t_user where username = #{userName} and password = #{password}")
    UserDto findStudentByUserNameAndPassword(Map<String,Object> map);
}

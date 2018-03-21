package com.zgf.service;

import com.zgf.dto.StudentDto;
import com.zgf.dto.UserDto;
import com.zgf.repository.StudentMapper;
import com.zgf.repository.UserMapper;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserDto findUserByUserNameAndPassword(Map<String,Object> map){
        return userMapper.findStudentByUserNameAndPassword(map);
    }
}

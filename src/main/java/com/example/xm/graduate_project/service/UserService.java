package com.example.xm.graduate_project.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.xm.graduate_project.controller.dto.UserDTO;
import com.example.xm.graduate_project.entity.TaskSingle;
import com.example.xm.graduate_project.entity.User;
import com.example.xm.graduate_project.mapper.UserMapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;

public interface UserService extends IService<User> {

//    @Autowired
//    private UserMapper userMapper;
//
//    public int save(User user) {
//        if(user.getUid() == null ) {
//            return userMapper.insert(user);
//        } else {
//            return userMapper.update(user);
//        }
//    }

}

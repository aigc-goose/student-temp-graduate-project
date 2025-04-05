package com.example.xm.graduate_project.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xm.graduate_project.entity.User;
import com.example.xm.graduate_project.mapper.UserMapper;
import com.example.xm.graduate_project.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
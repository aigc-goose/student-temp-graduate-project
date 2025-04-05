package com.example.xm.graduate_project.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xm.graduate_project.entity.Entity;
import com.example.xm.graduate_project.entity.Notice;
import com.example.xm.graduate_project.mapper.EntityMapper;
import com.example.xm.graduate_project.mapper.NoticeMapper;
import com.example.xm.graduate_project.service.EntityService;
import com.example.xm.graduate_project.service.NoticeService;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}

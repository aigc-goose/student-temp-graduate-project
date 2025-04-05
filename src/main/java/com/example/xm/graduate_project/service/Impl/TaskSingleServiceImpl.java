package com.example.xm.graduate_project.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xm.graduate_project.entity.Notice;
import com.example.xm.graduate_project.entity.TaskSingle;
import com.example.xm.graduate_project.mapper.NoticeMapper;
import com.example.xm.graduate_project.mapper.TaskSingleMapper;
import com.example.xm.graduate_project.service.NoticeService;
import com.example.xm.graduate_project.service.TaskSingleService;
import org.springframework.stereotype.Service;

@Service
public class TaskSingleServiceImpl extends ServiceImpl<TaskSingleMapper, TaskSingle> implements TaskSingleService {
}

package com.example.xm.graduate_project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.xm.graduate_project.entity.Entity;
import com.example.xm.graduate_project.entity.TaskSingle;
import com.example.xm.graduate_project.mapper.TaskSingleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface TaskSingleService extends IService<TaskSingle> {

//    @Autowired
//    private TaskSingleMapper taskSingleMapper;
//
//    public int save(TaskSingle taskSingle) {
//        if(taskSingle.getTid() == null) {
//            System.out.println("NULL");
//            return taskSingleMapper.insert(taskSingle);
//        } else {
//            return taskSingleMapper.update(taskSingle);
//        }
//    }

}

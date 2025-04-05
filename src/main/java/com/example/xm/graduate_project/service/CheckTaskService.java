package com.example.xm.graduate_project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.xm.graduate_project.entity.CheckTask;

import java.util.List;

/**
 * 核查任务Service接口
 */
public interface CheckTaskService extends IService<CheckTask> {

    /**
     * 查询所有核查任务
     */
    List<CheckTask> listAllCheckTasks();

    /**
     * 根据ID查询核查任务
     */
    CheckTask getCheckTaskById(Integer cid);

    /**
     * 根据任务ID查询核查任务
     */
    List<CheckTask> getCheckTasksByTaskId(Integer tid);

    /**
     * 根据用户ID查询核查任务
     */
    List<CheckTask> getCheckTasksByUserId(Integer uid);

    /**
     * 新增核查任务
     */
    boolean saveCheckTask(CheckTask checkTask);

    /**
     * 修改核查任务
     */
    boolean updateCheckTask(CheckTask checkTask);

    /**
     * 删除核查任务
     */
    boolean removeCheckTaskById(Integer cid);
}
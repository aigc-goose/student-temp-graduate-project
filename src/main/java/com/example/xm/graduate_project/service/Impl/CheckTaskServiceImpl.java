package com.example.xm.graduate_project.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xm.graduate_project.entity.CheckTask;
import com.example.xm.graduate_project.mapper.CheckTaskMapper;
import com.example.xm.graduate_project.service.CheckTaskService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 核查任务Service实现类
 */
@Service
public class CheckTaskServiceImpl extends ServiceImpl<CheckTaskMapper, CheckTask> implements CheckTaskService {

    @Override
    public List<CheckTask> listAllCheckTasks() {
        return list();
    }

    @Override
    public CheckTask getCheckTaskById(Integer cid) {
        return getById(cid);
    }

    @Override
    public List<CheckTask> getCheckTasksByTaskId(Integer tid) {
        LambdaQueryWrapper<CheckTask> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CheckTask::getTid, tid);
        return list(queryWrapper);
    }

    @Override
    public List<CheckTask> getCheckTasksByUserId(Integer uid) {
        LambdaQueryWrapper<CheckTask> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CheckTask::getUid, uid);
        return list(queryWrapper);
    }

    @Override
    public boolean saveCheckTask(CheckTask checkTask) {
        return save(checkTask);
    }

    @Override
    public boolean updateCheckTask(CheckTask checkTask) {
        return updateById(checkTask);
    }

    @Override
    public boolean removeCheckTaskById(Integer cid) {
        return removeById(cid);
    }
}
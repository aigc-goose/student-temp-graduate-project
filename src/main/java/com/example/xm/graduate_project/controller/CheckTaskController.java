package com.example.xm.graduate_project.controller;

import com.example.xm.graduate_project.common.Result;
import com.example.xm.graduate_project.entity.CheckTask;
import com.example.xm.graduate_project.service.CheckTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 核查任务控制器
 */
@RestController
@RequestMapping("/checkTasks")
public class CheckTaskController {

    @Autowired
    private CheckTaskService checkTaskService;

    /**
     * 获取所有核查任务
     */
    @GetMapping
    public Result getAllCheckTasks() {
        List<CheckTask> list = checkTaskService.listAllCheckTasks();
        return Result.success(list);
    }

    /**
     * 根据ID获取核查任务
     */
    @GetMapping("/{cid}")
    public Result getCheckTaskById(@PathVariable Integer cid) {
        CheckTask checkTask = checkTaskService.getCheckTaskById(cid);
        return Result.success(checkTask);
    }

    /**
     * 根据任务ID获取核查任务
     */
    @GetMapping("/task/{tid}")
    public Result getCheckTasksByTaskId(@PathVariable Integer tid) {
        List<CheckTask> list = checkTaskService.getCheckTasksByTaskId(tid);
        return Result.success(list);
    }

    /**
     * 根据用户ID获取核查任务
     */
    @GetMapping("/user/{uid}")
    public Result getCheckTasksByUserId(@PathVariable Integer uid) {
        List<CheckTask> list = checkTaskService.getCheckTasksByUserId(uid);
        return Result.success(list);
    }

    /**
     * 创建核查任务
     */
    @PostMapping
    public Boolean createCheckTask(@RequestBody CheckTask checkTask) {
        return checkTaskService.saveCheckTask(checkTask);
    }

    /**
     * 更新核查任务
     */
    @PutMapping("/{cid}")
    public Boolean updateCheckTask(@PathVariable Integer cid, @RequestBody CheckTask checkTask) {
        checkTask.setCid(cid);
        return checkTaskService.updateCheckTask(checkTask);
    }

    /**
     * 删除核查任务
     */
    @DeleteMapping("/{cid}")
    public Boolean deleteCheckTask(@PathVariable Integer cid) {
        return checkTaskService.removeCheckTaskById(cid);
    }
}
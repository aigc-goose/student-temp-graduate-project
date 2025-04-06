package com.example.xm.graduate_project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xm.graduate_project.common.Result;
import com.example.xm.graduate_project.entity.Notice;
import com.example.xm.graduate_project.entity.TaskSingle;
import com.example.xm.graduate_project.entity.User;
import com.example.xm.graduate_project.mapper.TaskSingleMapper;
import com.example.xm.graduate_project.service.TaskSingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasksingle")
public class TaskSingleController {

    @Resource
    private TaskSingleMapper taskSingleMapper;

    @Resource
    private TaskSingleService taskSingleService;

    @GetMapping
    public Result findAll() {
        QueryWrapper<TaskSingle> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("tid");
        return Result.success(taskSingleMapper.selectList(queryWrapper));
    }

    @GetMapping("/type/{value}")
    public Result findType(@PathVariable String value) {
        QueryWrapper<TaskSingle> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", value);
        return Result.success(taskSingleMapper.selectList(queryWrapper));
    }


    @PostMapping("/update")
    public Integer update(@RequestBody TaskSingle taskSingle) {
        return taskSingleMapper.updateById(taskSingle);
    }

    @PostMapping("/add")
    public Integer add(@RequestBody TaskSingle taskSingle) {
        System.out.println(taskSingle);
        return taskSingleMapper.insert(taskSingle);
    }

    @GetMapping("find/{tid}")
    public Result search(@PathVariable Integer tid) {
        return Result.success(taskSingleMapper.find(tid));
    }

    @PostMapping("/{tid}")
    public Integer delete(@PathVariable Integer tid) {
        return taskSingleMapper.deleteById(tid);
    }

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer tid, @RequestParam String type) {
        pageNum = (pageNum - 1) * pageSize;
        List<TaskSingle> data = taskSingleMapper.selectPage(pageNum, pageSize, tid, type);
        Integer total = taskSingleMapper.selectTotal(tid, type);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}

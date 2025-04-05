package com.example.xm.graduate_project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xm.graduate_project.common.Result;
import com.example.xm.graduate_project.entity.Entity;
import com.example.xm.graduate_project.entity.Notice;
import com.example.xm.graduate_project.entity.User;
import com.example.xm.graduate_project.mapper.NoticeMapper;
import com.example.xm.graduate_project.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private NoticeMapper noticeMapper;

    @Resource
    private NoticeService noticeService;

    @GetMapping
    public Result findAll() {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(noticeMapper.selectList(queryWrapper));
    }

    @PostMapping("/add")
    public Integer add(@RequestBody Notice notice) {
        return noticeMapper.insert(notice);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(noticeMapper.deleteById(id));
    }

    @PostMapping("/update")
    public Integer update(@RequestBody Notice notice) {
        return noticeMapper.updateById(notice);
    }

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<Notice> data = noticeMapper.selectPage(pageNum, pageSize);
        Integer total = noticeMapper.selectTotal();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}

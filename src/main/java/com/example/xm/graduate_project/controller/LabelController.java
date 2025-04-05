package com.example.xm.graduate_project.controller;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/5 0005
 * Time:17:36
 * Description:
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xm.graduate_project.common.Result;
import com.example.xm.graduate_project.entity.Label;
import com.example.xm.graduate_project.mapper.LabelMapper;
import com.example.xm.graduate_project.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 标注控制器
 */
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 添加标注
     */
    @PostMapping("/add")
    public Boolean add(@RequestBody Label label) {
        if (label.getLdate() == null) {
            label.setLdate(new Date());
        }

        return labelService.save(label);
    }

    /**
     * 删除标注
     */
    @DeleteMapping("/delete/{lid}")
    public Boolean delete(@PathVariable("lid") Integer lid) {
        return labelService.removeById(lid);
    }

    /**
     * 更新标注
     */
    @PutMapping("/update")
    public Boolean update(@RequestBody Label label) {
        return labelService.updateById(label);
    }

    /**
     * 根据ID查询标注
     */
    @GetMapping("/info/{lid}")
    public Result info(@PathVariable("lid") Integer lid) {
        Label label = labelService.getById(lid);
        return Result.success(label);
    }

    /**
     * 分页查询标注列表
     */
    @GetMapping("/list")
    public Map<String, Object> list(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {

        Page<Label> pageResult = labelService.page(new Page<>(pageNum, pageSize), new QueryWrapper<Label>());
        Map<String, Object> res = new HashMap<>();
        res.put("data", pageResult.getRecords());
        res.put("total", pageResult.getTotal());
        return res;
    }
}
package com.example.xm.graduate_project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xm.graduate_project.common.Result;
import com.example.xm.graduate_project.entity.Article;
import com.example.xm.graduate_project.entity.Notice;
import com.example.xm.graduate_project.mapper.ArticleMapper;
import com.example.xm.graduate_project.mapper.NoticeMapper;
import com.example.xm.graduate_project.service.ArticleService;
import com.example.xm.graduate_project.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private ArticleService articleService;

    @GetMapping
    public Result findAll() {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(articleMapper.selectList(queryWrapper));
    }

    @GetMapping("search/{content}")
    public Result search(@PathVariable String content) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", content);
        return Result.success(articleMapper.selectList(queryWrapper));
    }

    @GetMapping("find/{id}")
    public Result search(@PathVariable Integer id) {
        return Result.success(articleMapper.selectById(id));
    }

    @PostMapping("/add")
    public Integer add(@RequestBody Article article) {
        return articleMapper.insert(article);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(articleMapper.deleteById(id));
    }

    @PostMapping("/update")
    public Integer update(@RequestBody Article article) {
        return articleMapper.updateById(article);
    }

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam(required = false) Integer id,
                                        @RequestParam(required = false) String content) {

        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null,"id", id);
        queryWrapper.like(content != null,"content", content);
        queryWrapper.orderByDesc("id");

        Page<Article> page = new Page<>(pageNum, pageSize);
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);

        Map<String, Object> res = new HashMap<>();
        res.put("data", articlePage.getRecords());
        res.put("total", articlePage.getTotal());
        return res;
    }
}

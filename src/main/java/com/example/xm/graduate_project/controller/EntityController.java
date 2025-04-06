package com.example.xm.graduate_project.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xm.graduate_project.common.Result;
import com.example.xm.graduate_project.entity.Article;
import com.example.xm.graduate_project.entity.Entity;
import com.example.xm.graduate_project.entity.TaskSingle;
import com.example.xm.graduate_project.mapper.EntityMapper;
import com.example.xm.graduate_project.service.EntityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entity")
public class EntityController {

    @Resource
    private EntityMapper entityMapper;

    @Resource
    private EntityService entityService;


    @GetMapping("/{tid}")
    public Result findAll(@PathVariable Integer tid) {
        QueryWrapper<Entity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tid", tid);
        queryWrapper.orderByDesc("id");
        return Result.success(entityMapper.selectList(queryWrapper));
    }

    @PostMapping("/add")
    public Integer add(@RequestBody Entity entity) {
        return entityMapper.insert(entity);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(entityMapper.deleteById(id));
    }

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam(required = false) Integer id,
                                        @RequestParam(required = false) String tid) {

        QueryWrapper<Entity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null,"id", id);
        queryWrapper.eq(tid != null,"tid", tid);

        Page<Entity> page = new Page<>(pageNum, pageSize);
        Page<Entity> entityPage = entityMapper.selectPage(page, queryWrapper);

        Map<String, Object> res = new HashMap<>();
        res.put("data", entityPage.getRecords());
        res.put("total", entityPage.getTotal());
        return res;
    }

//    导出接口
    @GetMapping("/export/{tid}&{tname}")
    public void export(@PathVariable Integer tid,@PathVariable String tname,HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        QueryWrapper<Entity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tid",tid);
        List<Entity> list = entityMapper.selectList(queryWrapper);
        // 通过工具类创建writer 写出到磁盘路径
    //        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("id", "序号");
        writer.addHeaderAlias("content", "图片内容");
        writer.addHeaderAlias("type", "类型");
        writer.addHeaderAlias("ldata", "是否遥感图像");

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode(tname, "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

    /**
     * excel 导入
     * @param file
     * @throws Exception
     */
    @PostMapping("/import")
    public Result imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 方式1：(推荐) 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
//        List<User> list = reader.readAll(User.class);

        // 方式2：忽略表头的中文，直接读取表的内容
        List<List<Object>> list = reader.read(1);
        List<Entity> entities = CollUtil.newArrayList();
        for (List<Object> row : list) {
            Entity entity = new Entity();
            entity.setContent(row.get(0).toString());
            entity.setType(row.get(1).toString());
            entity.setLdata(row.get(2).toString());
            entities.add(entity);
        }

        entityService.saveBatch(entities);
        return Result.success(true);
    }

}

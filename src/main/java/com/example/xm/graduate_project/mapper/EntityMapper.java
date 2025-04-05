package com.example.xm.graduate_project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xm.graduate_project.entity.Article;
import com.example.xm.graduate_project.entity.Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EntityMapper extends BaseMapper<Entity> {
    @Select("select count(*) from entity")
    Integer selectTotal();

    @Select("select * from entity limit #{pageNum}, #{pageSize}")
    List<Entity> selectPage(Integer pageNum, Integer pageSize);
}

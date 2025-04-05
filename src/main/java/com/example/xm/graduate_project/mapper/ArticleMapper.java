package com.example.xm.graduate_project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xm.graduate_project.entity.Article;
import com.example.xm.graduate_project.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    @Select("select count(*) from article")
    Integer selectTotal();

    @Select("select * from article limit #{pageNum}, #{pageSize}")
    List<Article> selectPage(Integer pageNum, Integer pageSize);
}

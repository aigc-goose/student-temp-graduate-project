package com.example.xm.graduate_project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xm.graduate_project.entity.Notice;
import com.example.xm.graduate_project.entity.TaskSingle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {
    @Select("select count(*) from notice")
    Integer selectTotal();

    @Select("select * from notice limit #{pageNum}, #{pageSize}")
    List<Notice> selectPage(Integer pageNum, Integer pageSize);
}

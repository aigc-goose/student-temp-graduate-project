package com.example.xm.graduate_project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xm.graduate_project.entity.Notice;
import com.example.xm.graduate_project.entity.TaskSingle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskSingleMapper extends BaseMapper<TaskSingle> {

//    int update(TaskSingle taskSingle);
//
//    int insert(TaskSingle taskSingle);
//
//    List<TaskSingle> findAll();
//
//    Integer deleteById(Integer tid);

    @Select("select * from tasksingle where tname like concat('%',#{tname},'%') limit #{pageNum}, #{pageSize}")
    List<TaskSingle> selectPage(Integer pageNum, Integer pageSize, String tname);

    @Select("select count(*) from tasksingle where tname like concat('%',#{tname},'%')")
    Integer selectTotal(String tname);

    @Select("select * from tasksingle where tid=#{tid}")
    TaskSingle find(Integer tid);
}

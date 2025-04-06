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

    @Select("select * from tasksingle where tid = #{tid} or type like concat('%',#{type},'%')  limit #{pageNum}, #{pageSize}")
    List<TaskSingle> selectPage(Integer pageNum, Integer pageSize, Integer tid, String type);

    @Select("select count(*) from tasksingle where tid = #{tid} or type like concat('%',#{type},'%') ")
    Integer selectTotal(Integer tid, String type);

    @Select("select * from tasksingle where tid=#{tid}")
    TaskSingle find(Integer tid);
}

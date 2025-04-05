package com.example.xm.graduate_project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xm.graduate_project.entity.CheckTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * 核查任务Mapper接口
 */
@Mapper
public interface CheckTaskMapper extends BaseMapper<CheckTask> {
}
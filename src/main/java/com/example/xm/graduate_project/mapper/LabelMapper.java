package com.example.xm.graduate_project.mapper;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/5 0005
 * Time:17:33
 * Description:
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xm.graduate_project.entity.Label;
import org.apache.ibatis.annotations.Mapper;

/**
 * 标注Mapper接口
 */
@Mapper
public interface LabelMapper extends BaseMapper<Label> {
}
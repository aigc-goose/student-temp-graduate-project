package com.example.xm.graduate_project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 标注实体类
 */
@Data
@TableName("label")
public class Label implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标注记录编号
     */
    @TableId(value = "lid", type = IdType.AUTO)
    private Integer lid;

    /**
     * 任务编号
     */
    private Integer tid;

    /**
     * 标注日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ldate;

    /**
     * 标注类型
     */
    private Integer ltype;
}
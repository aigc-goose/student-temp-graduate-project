package com.example.xm.graduate_project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

/**
 * 核查任务实体类
 */
@Data
@TableName("check_task")
public class CheckTask implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 核查任务编号
     */
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    /**
     * 任务编号
     */
    private Integer tid;

    /**
     * 核查人员ID
     */
    private Integer uid;

    /**
     * 核查状态
     */
    private Double cstatus;

    /**
     * 核查记录
     */
    private String cwords;
}
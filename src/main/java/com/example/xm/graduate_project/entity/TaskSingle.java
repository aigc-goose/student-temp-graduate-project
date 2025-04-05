package com.example.xm.graduate_project.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@TableName("tasksingle")
public class TaskSingle {

    @TableId(type = IdType.AUTO)
    private Integer tid;
    private Integer uid;
    private String tname;
    private String work;
    private String createTime;
    private String time;
    private String type;
    private double tstatus;
    private String result;
    private String comment;
    private Integer rate;
}

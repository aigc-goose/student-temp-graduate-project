package com.example.xm.graduate_project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@TableName("entity")
@ToString
public class Entity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer tid;
    private String content;
    private String type;
    private String ldata;
}

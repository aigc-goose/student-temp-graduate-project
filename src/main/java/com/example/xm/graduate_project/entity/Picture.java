package com.example.xm.graduate_project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("picture")
public class Picture {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String content;
    private String type;
    private String url;
    private String md5;
}

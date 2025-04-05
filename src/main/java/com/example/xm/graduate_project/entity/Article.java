package com.example.xm.graduate_project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("article")
public class Article {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String image;
    private String content;
    private String createTime;
}

package com.example.xm.graduate_project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@TableName("notice")
public class Notice {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String content;
    private String createTime;
}

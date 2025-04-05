package com.example.xm.graduate_project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer uid;
    private String username;
    private String nickname;
//    @JsonIgnore // 忽略某个字段不展示给前端
    private String password;
    private String email;
    private String phone;
    private String avatarurl;
    private String role;
}

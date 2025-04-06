package com.example.xm.graduate_project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

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
    /**
     * 组织: 个人/团队
     */
    private Integer organization;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}

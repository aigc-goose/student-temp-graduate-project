package com.example.xm.graduate_project.controller.dto;

import lombok.Data;

/**
 * 接受前端登录请求的参数
 */
@Data
public class UserDTO {
    private String username;
    private String password;
}
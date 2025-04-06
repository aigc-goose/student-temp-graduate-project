package com.example.xm.graduate_project.controller.dto;

import lombok.Data;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/6 0006
 * Time:11:49
 * Description:
 */
@Data
public class TaskPKDTO {

    /**
     * 角色 个人或团队
     */
    private Integer role;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 统计数量
     */
    private Integer count;
}

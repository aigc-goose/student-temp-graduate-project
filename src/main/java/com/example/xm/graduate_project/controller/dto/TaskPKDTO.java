package com.example.xm.graduate_project.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/6 0006
 * Time:11:49
 * Description:
 */
@Data
@AllArgsConstructor
public class TaskPKDTO {

    /**
     * 组织  0是个人 1是团队
     */
    private Integer organization;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 统计数量
     */
    private Integer count;
}

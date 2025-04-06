package com.example.xm.graduate_project.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/6 0006
 * Time:11:54
 * Description:
 */
@Data
@AllArgsConstructor
public class TaskRateDTO {

    /**
     * 状态
     */
    private Integer status;

    /**
     * 数量
     */
    private Long count;
}

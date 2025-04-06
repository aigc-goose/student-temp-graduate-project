package com.example.xm.graduate_project.controller.dto;

import lombok.Data;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/6 0006
 * Time:11:54
 * Description:
 */
@Data
public class TaskRateDTO {

    /**
     * 状态
     */
    private Integer status;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 百分比
     */
    private Double percentage;
}

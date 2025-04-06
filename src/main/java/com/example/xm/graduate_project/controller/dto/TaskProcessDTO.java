package com.example.xm.graduate_project.controller.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/6 0006
 * Time:11:52
 * Description:
 */
@Data
public class TaskProcessDTO {


    /**
     * 日期
     */
    private Date date;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 数量
     */
    private Integer count;
}

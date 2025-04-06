package com.example.xm.graduate_project.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/6 0006
 * Time:11:47
 * Description:
 */
@Data
@AllArgsConstructor
public class TaskStatisticsDTO {



    /**
     * 状态 0:未开始 1:处理中 2:已处理 3:已核查
     */
    private Integer status;

    /**
     * 数量
     */
    private Long count;
}

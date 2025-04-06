package com.example.xm.graduate_project.service;

import com.example.xm.graduate_project.common.Result;
import com.example.xm.graduate_project.controller.dto.TaskPKDTO;
import com.example.xm.graduate_project.controller.dto.TaskProcessDTO;
import com.example.xm.graduate_project.controller.dto.TaskRateDTO;
import com.example.xm.graduate_project.controller.dto.TaskStatisticsDTO;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/6 0006
 * Time:14:21
 * Description:
 */
public interface DataAnalysisService {

    /**
     * 任务处理状态图
     * @return
     */
    public List<TaskStatisticsDTO> taskStatistics();

    /**
     * 个人团队任务对比图
     * @return
     */
    public List<TaskPKDTO> taskPK();


    /**
     * 任务进度图
     * @return
     */
    public List<TaskProcessDTO> taskProcess();

    /**
     * 任务占比图
     * @return
     */
    public List<TaskRateDTO> taskRate();
}

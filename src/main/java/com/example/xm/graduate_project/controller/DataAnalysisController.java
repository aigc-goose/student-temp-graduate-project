package com.example.xm.graduate_project.controller;

import com.example.xm.graduate_project.common.Result;
import com.example.xm.graduate_project.controller.dto.TaskPKDTO;
import com.example.xm.graduate_project.controller.dto.TaskProcessDTO;
import com.example.xm.graduate_project.controller.dto.TaskRateDTO;
import com.example.xm.graduate_project.controller.dto.TaskStatisticsDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/6 0006
 * Time:10:05
 * Description:
 */
@RestController
@RequestMapping("/dataanalysis")
public class DataAnalysisController {


    /**
     * 任务处理状态图
     * @return
     */
    @RequestMapping("/taskStatistics")
    public Result taskStatistics(){

        List<TaskStatisticsDTO> list = null;
        return Result.success(list);
    }

    /**
     * 个人团队任务对比图
     * @return
     */
    @RequestMapping("/taskPK")
    public Result taskPK(){

        List<TaskPKDTO> list = null;
        return Result.success(list);
    }


    /**
     * 任务进度图
     * @return
     */
    @RequestMapping("/taskProcess")
    public Result taskProcess(){

        List<TaskProcessDTO> list = null;
        return Result.success(list);
    }

    /**
     * 任务占比图
     * @return
     */
    @RequestMapping("/taskRate")
    public Result taskRate(){

        List<TaskRateDTO> list = null;
        return Result.success(list);
    }
}

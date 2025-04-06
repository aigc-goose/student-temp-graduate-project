package com.example.xm.graduate_project.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xm.graduate_project.controller.dto.TaskPKDTO;
import com.example.xm.graduate_project.controller.dto.TaskProcessDTO;
import com.example.xm.graduate_project.controller.dto.TaskRateDTO;
import com.example.xm.graduate_project.controller.dto.TaskStatisticsDTO;
import com.example.xm.graduate_project.entity.CheckTask;
import com.example.xm.graduate_project.entity.TaskSingle;
import com.example.xm.graduate_project.entity.User;
import com.example.xm.graduate_project.service.CheckTaskService;
import com.example.xm.graduate_project.service.DataAnalysisService;
import com.example.xm.graduate_project.service.TaskSingleService;
import com.example.xm.graduate_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * Date:2025/4/6 0006
 * Time:14:21
 * Description:
 */
@Service
public class DataAnalysisServiceImpl implements DataAnalysisService {

    @Autowired
    private TaskSingleService taskSingleService;
    @Autowired
    private CheckTaskService checkTaskService;
    @Autowired
    private UserService userService;



    @Override
    public List<TaskStatisticsDTO> taskStatistics() {

        Integer[] statusArr = {0, 1, 2, 3};
        List<TaskStatisticsDTO> list = new ArrayList<>();
        for (Integer tstatus : statusArr) {

            Long count = null;
            if (tstatus != 3){
                count = taskSingleService.count(taskStatisticsQueryWrapper(tstatus));
            }else{
                // 添加已核查的数据
                LambdaQueryWrapper<CheckTask> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper .eq(CheckTask::getCstatus, 1);
                count = checkTaskService.count(queryWrapper);
            }
            list.add(new TaskStatisticsDTO(tstatus,count));
        }

        return list;
    }


    @Override
    public List<TaskPKDTO> taskPK() {

        Integer[] statusArr = {0, 1, 2, 3}; //3为已核查
        List<TaskPKDTO> result = new ArrayList<>();
        for (Integer tstatus : statusArr) {

            if (tstatus != 3){

                List<TaskSingle> list = taskSingleService.list(taskStatisticsQueryWrapper(tstatus));
                List<Integer> uidList = list.stream().map(TaskSingle::getUid).collect(Collectors.toList());
                List<User> users = userService.listByIds(uidList);
                int userCount = 0;
                for (User user : users) {
                    if (user.getOrganization() == 0){
                        userCount++;
                    }
                }
                result.add(new TaskPKDTO(0, tstatus,userCount));
                result.add(new TaskPKDTO(1, tstatus,users.size() - userCount));

            }else{
                // 添加已核查的数据
                LambdaQueryWrapper<CheckTask> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper .eq(CheckTask::getCstatus, 1);
                List<CheckTask> list = checkTaskService.list(queryWrapper);
                List<Integer> uidList = list.stream().map(CheckTask::getUid).collect(Collectors.toList());
                List<User> users = userService.listByIds(uidList);
                int userCount = 0;
                for (User user : users) {
                    if (user.getOrganization() == 0){
                        userCount++;
                    }
                }
                result.add(new TaskPKDTO(0, tstatus,userCount));
                result.add(new TaskPKDTO(1, tstatus,users.size() - userCount));
            }
        }
        return result;
    }


    @Override
    public List<TaskProcessDTO> taskProcess() {
        // 创建查询构造器
        QueryWrapper<TaskSingle> queryWrapper = new QueryWrapper<>();

        // 设置时间范围条件 - 最近一周
        queryWrapper.ge("create_time", LocalDateTime.now().minusDays(7));

        // 选择日期、状态并计数
        queryWrapper.select("DATE(create_time) as date, tstatus as status, count(*) as count");

        // 按日期和状态分组
        queryWrapper.groupBy("DATE(create_time), tstatus");

        // 按日期排序
        queryWrapper.orderByAsc("date");

        // 执行查询
        List<TaskProcessDTO> result = new ArrayList<>();
        List<Map<String, Object>> listMaps = taskSingleService.listMaps(queryWrapper);
        if (listMaps != null && !listMaps.isEmpty()) {
            for (Map<String, Object> m : listMaps) {
                TaskProcessDTO taskProcessDTO = new TaskProcessDTO();
                taskProcessDTO.setDate(LocalDate.parse(m.get("date").toString()));
                taskProcessDTO.setStatus(Integer.parseInt(m.get("status").toString()));
                taskProcessDTO.setCount(Integer.parseInt(m.get("count").toString()));
                result.add(taskProcessDTO);
            }
        }

        return result;
    }


    @Override
    public List<TaskRateDTO> taskRate() {
        Integer[] statusArr = {0, 1, 2, 3};
        List<TaskRateDTO> list = new ArrayList<>();
        for (Integer tstatus : statusArr) {

            Long count = null;
            if (tstatus != 3){
                count = taskSingleService.count(taskStatisticsQueryWrapper(tstatus));
            }else{
                // 添加已核查的数据
                LambdaQueryWrapper<CheckTask> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper .eq(CheckTask::getCstatus, 1);
                count = checkTaskService.count(queryWrapper);
            }
            list.add(new TaskRateDTO(tstatus,count));
        }
        return list;
    }


    /**
     * 封装查询条件
     * @param tstatus
     * @return
     */
    private LambdaQueryWrapper<TaskSingle> taskStatisticsQueryWrapper(Integer tstatus){
        LambdaQueryWrapper<TaskSingle> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper .eq(TaskSingle::getTstatus, tstatus);
        return queryWrapper;
    }


}


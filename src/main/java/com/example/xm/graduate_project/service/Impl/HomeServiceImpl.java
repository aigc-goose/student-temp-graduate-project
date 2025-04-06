package com.example.xm.graduate_project.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xm.graduate_project.controller.dto.HomeDataDTO;
import com.example.xm.graduate_project.entity.TaskSingle;
import com.example.xm.graduate_project.entity.User;
import com.example.xm.graduate_project.service.HomeService;
import com.example.xm.graduate_project.service.TaskSingleService;
import com.example.xm.graduate_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/6 0006
 * Time:14:06
 * Description:
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskSingleService taskSingleService;


    @Override
    public HomeDataDTO getHomeData() {

        QueryWrapper<TaskSingle> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tstatus",2);
        long finishedTaskCount = taskSingleService.count(queryWrapper);
        long userCount = userService.count();
        long taskCount = taskSingleService.count();

        // 最近15天用户新增统计
        List<HomeDataDTO.UserActive> userAddedStatistics = this.getUserAddedStatistics();

        HomeDataDTO homeDataDTO = new HomeDataDTO();
        homeDataDTO.setUserCount(userCount);
        homeDataDTO.setTaskCount(taskCount);
        homeDataDTO.setFinishedTaskCount(finishedTaskCount);

        homeDataDTO.setUserActiveList(userAddedStatistics);
        return null;
    }


    /**
     * 获取最近15天的用户新增统计
     * @return
     */
    private List<HomeDataDTO.UserActive> getUserAddedStatistics() {
        // 获取15天前的日期
        LocalDate startDate = LocalDate.now().minusDays(14);

        // 创建查询条件
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(User::getCreateTime, LocalDateTime.of(startDate, LocalTime.MIN));

        // 查询这段时间内的所有用户
        List<User> users = userService.list(wrapper);

        // 按日期分组并统计
        Map<LocalDate, Long> userCountMap = users.stream()
                .collect(Collectors.groupingBy(
                        user -> user.getCreateTime().toLocalDate(),
                        Collectors.counting()
                ));

        // 生成最近15天的日期列表
        List<HomeDataDTO.UserActive> result = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            LocalDate date = startDate.plusDays(i);
            HomeDataDTO.UserActive dto = new HomeDataDTO.UserActive();
            dto.setDate(date);
            dto.setUserAddCount(userCountMap.getOrDefault(date, 0L).intValue());
            result.add(dto);
        }

        return result;
    }
}

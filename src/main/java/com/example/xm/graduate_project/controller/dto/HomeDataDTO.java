package com.example.xm.graduate_project.controller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/6 0006
 * Time:12:06
 * Description:
 */
@Data
public class HomeDataDTO {

    private Long userCount;

    private Long taskCount;

    private Long finishedTaskCount;


    private List<UserActive> userActiveList;



    @Data
    public static  class UserActive{

        /**
         * 日期
         */
        private LocalDate date;

        /**
         * 数量新增用户  todo 这里原本是活跃用户
         */
        private Integer userAddCount;

    }
}

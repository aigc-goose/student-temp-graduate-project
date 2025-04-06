package com.example.xm.graduate_project.controller.dto;

import lombok.Data;

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

    private Integer userCount;

    private Integer taskCount;

    private Integer finishedTaskCount;


    private List<UserActive> userActiveList;



    @Data
    public static  class UserActive{

        /**
         * 日期
         */
        private String date;

        /**
         * 数量新增用户  todo 这里原本是活跃用户
         */
        private Integer userAddCount;

    }
}

package com.example.xm.graduate_project.controller;

import com.example.xm.graduate_project.common.Result;
import com.example.xm.graduate_project.controller.dto.HomeDataDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IDEA
 * author:youle
 * Date:2025/4/6 0006
 * Time:12:05
 * Description: 首页接口
 */
@RestController
@RequestMapping("/home")
public class HomeController {



    /**
     * 首页数据接口
     * @return
     */
    @RequestMapping("/data")
    public Result taskStatistics(){

        List<HomeDataDTO> list = null;
        return Result.success(list);
    }

}

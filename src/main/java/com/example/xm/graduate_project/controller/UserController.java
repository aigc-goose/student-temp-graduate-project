package com.example.xm.graduate_project.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xm.graduate_project.common.Constants;
import com.example.xm.graduate_project.common.Result;
import com.example.xm.graduate_project.controller.dto.UserDTO;
import com.example.xm.graduate_project.entity.Entity;
import com.example.xm.graduate_project.entity.User;
import com.example.xm.graduate_project.mapper.UserMapper;
import com.example.xm.graduate_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;


    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if(userMapper.login(username, password) != 0){
            return Result.success("登录成功！");
        }
        return Result.error(Constants.CODE_500, "用户名或密码错误");
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        System.out.println(user);
        if(userMapper.getUid(username) == null) {
            if(userMapper.insert(user) == 1)
                return Result.success("注册成功！");
        }
        return Result.error(Constants.CODE_500, "用户名已经存在");
    }

    @GetMapping("/{username}")
    public User getUid(@PathVariable String username) {
        return userMapper.getUid(username);
    }

    //新增
    @PostMapping("/add")
    public Integer add(@RequestBody User user) {
        return userMapper.insert(user);
    }

    //更新
    @PostMapping("/update")
    public Integer update(@RequestBody User user) {
        return userMapper.updateById(user);
    }

    //查询所有数据
    @GetMapping
    public List<User> index() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return userMapper.selectList(queryWrapper);
    }

    //删除数据
    @DeleteMapping("/{uid}")
    public Integer delete(@PathVariable Integer uid) {
        return userMapper.deleteById(uid);
    }

    // 分页查询
    // 接口路径： /user/page
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = userMapper.selectPage(pageNum, pageSize);
        Integer total = userMapper.selectTotal();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}

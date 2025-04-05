package com.example.xm.graduate_project.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xm.graduate_project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {


//    List<User> findAll();
//
//    int update(User user);
//
//    int insert(User user);
//
//    Integer deleteById(Integer uid);

    List<User> selectPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from user")
    Integer selectTotal();

    @Select("select * from USER where username =#{username}")
    User getUid(String username);

    @Select("select count(*) from user where username = #{username} and password = #{password}")
    Integer login(String username, String password);
}

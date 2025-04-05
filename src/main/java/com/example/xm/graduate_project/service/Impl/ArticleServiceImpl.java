package com.example.xm.graduate_project.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xm.graduate_project.entity.Article;
import com.example.xm.graduate_project.entity.Notice;
import com.example.xm.graduate_project.mapper.ArticleMapper;
import com.example.xm.graduate_project.mapper.NoticeMapper;
import com.example.xm.graduate_project.service.ArticleService;
import com.example.xm.graduate_project.service.NoticeService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}

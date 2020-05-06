/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.service;

import com.sd.mapper.ArticleMapper;
import com.sd.mapper.CommentMapper;
import com.sd.entity.Article;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CommentMapper commentMapper;
    
    //通过id查询文章详情，同时增加文章点击量
    public Article selectArticleById(Integer id) {
        articleMapper.updateArticleHitsById(id);
        return  articleMapper.selectArticleById(id);
    }
    
    //查询所有文章列表 按发布时间 不带评论
    public List<Article> selectArticlesOrderByDate() {
        return  articleMapper.selectArticlesOrderByDate();
    }
    
    //查询所有文章列表 按热度 不带评论
    public List<Article> selectArticlesOrderByHits() {
        return  articleMapper.selectArticlesOrderByHits();
    }
    
    //查询全部文章列表和所有评论
    public List<Article> selectTitlesWithComment() {
        return  articleMapper.selectTitlesWithComment();
    }
    
    //发布文章
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }
    
    //修改文章
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }
    
    //通过id删除文章，同时删除所有评论
    public void deleteArticleById(Integer id) {
        articleMapper.deleteArticleById(id);
        commentMapper.deleteCommentByArticleId(id);
    }	

}

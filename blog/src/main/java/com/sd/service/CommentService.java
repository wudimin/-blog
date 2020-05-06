/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.service;

import com.sd.mapper.ArticleMapper;
import com.sd.mapper.CommentMapper;
import com.sd.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ArticleMapper articleMapper;

    //发布评论，同时增加该文章评论量
    public void insertComment(Comment comment) {
        commentMapper.insertComment(comment);
        articleMapper.updateArticleCommentsById(comment.getArticleid());
    }

    //通过评论id删除评论
    public void deleteCommentById(Integer id) {
        commentMapper.deleteCommentById(id);
    }
    
    //通过文章id删除该文章下所有评论
    public void deleteCommentByArticleId(Integer id) {
        commentMapper.deleteCommentByArticleId(id);
    }	
}

package com.sd.mapper;

import com.sd.entity.Comment;

public interface CommentMapper {

	//发布评论
	public void insertComment(Comment comment);

	//根据id删除评论
	public void deleteCommentById(Integer id);
	
	//根据article_id删除该文章所有评论
	public void deleteCommentByArticleId(Integer id);

}

package com.sd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.sd.entity.Comment;
import com.sd.service.CommentService;

@CrossOrigin
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	//发布评论
	@PostMapping("/comment")
	public String insertComment(@RequestBody Comment comment) {
            commentService.insertComment(comment);
            return "success" ;
	}
	
	//删除评论
	@DeleteMapping("/comment/{id}")
	public String deleteCommentById(@PathVariable("id") Integer id) {
            commentService.deleteCommentById(id);
            return "success" ;
	}
        
	//通过文章id删除该文章下所有评论
	@DeleteMapping("/comments/{id}")
	public String deleteCommentByArticleId(@PathVariable("id") Integer id) {
            commentService.deleteCommentByArticleId(id);
            return "success" ;
	}
}

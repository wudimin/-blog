package com.sd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sd.entity.Comment;
import com.sd.service.CommentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {

        @Autowired
        private CommentService commentService;
        
        @Test
	public void insert() {
            Comment comment = new Comment();
            comment.setArticleid(1);
            comment.setContent("赞！");
            commentService.insertComment(comment);
            System.out.println(comment.getId());
	}
        
        @Test
	public void delete() {
            commentService.deleteCommentById(4);
	}

}

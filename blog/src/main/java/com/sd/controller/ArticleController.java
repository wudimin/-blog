package com.sd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.sd.entity.Article;
import com.sd.service.ArticleService;

@CrossOrigin
@RestController
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	//根据id查询文章详情
	@GetMapping("/article/{id}")
	public Article selectArticleById(@PathVariable("id") Integer id) {
            Article article = articleService.selectArticleById(id);
            return article;
	}
	
	//按发表日期查询文章列表
	@GetMapping("/articles")
	public List<Article> selectArticlesOrderByDate(){
            List<Article> articles = articleService.selectArticlesOrderByDate();
            return articles; 
	}
	
	//按热度查询文章列表
	@GetMapping("/top")
	public List<Article> selectArticlesOrderByHits(){
            List<Article> articles = articleService.selectArticlesOrderByHits();
            return articles; 
	}
        
	//查询全部文章列表和所有评论
	@GetMapping("/comments")
	public List<Article> selectTitlesWithComment(){
            List<Article> articles = articleService.selectTitlesWithComment();
            return articles; 
	}

	//发布文章
	@PostMapping("/article")
	public String insertArticle(Article article) {
            articleService.insertArticle(article);
            return "success" ;
	}
	
	//修改文章
	@PutMapping("/article")
	public String updateArticle(@RequestBody Article article) {
            articleService.updateArticle(article);
            return "success" ;
	}
	
	//删除文章
	@DeleteMapping("/article/{id}")
	public String deleteArticleById(@PathVariable("id") Integer id) {
            articleService.deleteArticleById(id);
            return "success" ;
	}

}

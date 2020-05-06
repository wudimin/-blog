package com.sd;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sd.entity.Article;
import java.util.List;
import com.sd.service.ArticleService;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {

        @Autowired
        private ArticleService articleService;
        
        @Test
	public void testSelect() {
            List<Article> articles=articleService.selectArticlesOrderByDate();
            System.out.println(articles.toString());
        }
        
       @Test
	public void testSelectComments() {
            List<Article> articles=articleService.selectTitlesWithComment();
            System.out.println(articles.toString());
        }   
        
        @Test
	public void testSelectById() {
            Article article=articleService.selectArticleById(1);
            System.out.println(article.toString());
        }
          
        @Test
	public void testInsert() {
            Article article = new Article();
            article.setTitle("头条新闻");
            article.setContent("佩奇");
            article.setThumbnail("缩略图");
            articleService.insertArticle(article);
            System.out.println(article.getId());
	}
        
	@Test
	public void testUpdate() {
            Article article = new Article();
            article.setId(4);
            article.setTitle("头条新闻小猪佩奇");
            article.setContent("小猪佩奇");
            articleService.updateArticle(article);
	}
        
        @Test
	public void testDelete() {
            articleService.deleteArticleById(4);
	}	

}

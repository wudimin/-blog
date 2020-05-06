package com.sd.entity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Article {
    //流水号
    private Integer id;
    //标题
    private String title;
    //内容
    private String content;
    //日期
    private String created;
    //缩略图
    private String thumbnail;
    //点击量
    private Integer hits;
    //评论量
    private Integer comments;
    //评论
    private List<Comment> commentList;
    
}
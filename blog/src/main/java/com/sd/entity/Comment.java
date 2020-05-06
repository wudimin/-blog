package com.sd.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Comment {
    //评论流水号
    private Integer id;
    //文章流水号
    private Integer articleid;
    //评论内容
    private String content;
    //日期
    private String created;
    //用户名
    private String author;
    
}
package com.sd.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Notice {
    //流水号
    private Integer id;
    //标题
    private String title;
    //内容
    private String content;
    //日期
    private String created;
}
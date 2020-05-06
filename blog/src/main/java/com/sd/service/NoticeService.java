/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.service;

import com.sd.entity.Notice;
import com.sd.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    
    @Autowired
    private NoticeMapper noticeMapper;
    
    //通过id查询公告详情
    public Notice selectNoticeById(Integer id) {
        return  noticeMapper.selectNoticeById(id);
    }
    
    //查询所有公告列表 按发布时间
    public List<Notice> selectNoticesOrderByDate() {
        return  noticeMapper.selectNoticesOrderByDate();
    }

    
    //发布公告
    public void insertNotice(Notice notice) {
        noticeMapper.insertNotice(notice);
    }
    
    //修改文章
    public void updateNotice(Notice notice) {
        noticeMapper.updateNotice(notice);
    }
    
    //通过id删除公告
    public void deleteNoticeById(Integer id) {
        noticeMapper.deleteNoticeById(id);
    }	

}

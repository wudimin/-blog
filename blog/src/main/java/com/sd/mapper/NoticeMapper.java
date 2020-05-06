package com.sd.mapper;

import com.sd.entity.Notice;

import java.util.List;

public interface NoticeMapper {

	//根据id查询公告详情
	public Notice selectNoticeById(Integer id);
	
	//查询全部文章列表
	public List<Notice> selectNoticesOrderByDate();

        //发布文章
	public void insertNotice(Notice notice);

        //根据id修改文章
	public void updateNotice(Notice notice);
	
	//根据id删除文章
	public void deleteNoticeById(Integer id);

}

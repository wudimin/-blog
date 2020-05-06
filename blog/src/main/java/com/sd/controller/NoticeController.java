package com.sd.controller;

import com.sd.entity.Notice;
import com.sd.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	//根据id查询公告详情
	@GetMapping("/notice/{id}")
	public Notice selectNoticeById(@PathVariable("id") Integer id) {
		Notice notice = noticeService.selectNoticeById(id);
            return notice;
	}
	
	//按发表日期查询公告列表
	@GetMapping("/notices")
	public List<Notice> selectNoticesOrderByDate(){
            List<Notice> notices = noticeService.selectNoticesOrderByDate();
            return notices;
	}


	//发布公告
	@PostMapping("/notice")
	public String insertNotice(Notice notice) {
		noticeService.insertNotice(notice);
            return "success" ;
	}
	
	//修改公告
	@PutMapping("/notice")
	public String updateNotice(Notice notice) {
		noticeService.updateNotice(notice);
            return "success" ;
	}
	
	//删除公告
	@DeleteMapping("/notice/{id}")
	public String deleteNoticeById(@PathVariable("id") Integer id) {
		noticeService.deleteNoticeById(id);
            return "success" ;
	}

}

package com.sd;

import com.sd.entity.Notice;
import com.sd.service.NoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeTest {

        @Autowired
        private NoticeService  noticeService;
        
        @Test
	public void testSelect() {
            List<Notice> notice= noticeService.selectNoticesOrderByDate();
            System.out.println(notice.toString());
        }

        
        @Test
	public void testSelectById() {
            Notice notice= noticeService.selectNoticeById(1);
            System.out.println(notice.toString());
        }
          
        @Test
	public void testInsert() {
            Notice notice = new Notice();
            notice.setTitle("头条新闻");
            notice.setContent("佩奇");
            noticeService.insertNotice(notice);
            System.out.println( notice.getId());
	}
        
	@Test
	public void testUpdate() {
            Notice  notice = new  Notice();
            notice.setId(4);
            notice.setTitle("头条新闻小猪佩奇");
            notice.setContent("小猪佩奇");
            noticeService.updateNotice(notice);
	}
        
        @Test
	public void testDelete() {
            noticeService.deleteNoticeById(4);
	}	

}

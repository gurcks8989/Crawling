package com.spring.handong.top;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.user.UserServiceImpl;
import com.spring.user.UserVO;
import com.spring.crawling.CrawlingVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TopController {

	@Autowired
	UserServiceImpl service;
	
	@RequestMapping(value = "/handong", method = RequestMethod.GET)
	public String main(HttpSession session,Locale locale, Model model) {
		UserVO uservo = new UserVO();
		List<CrawlingVO> noticeList = new ArrayList<CrawlingVO>();
		uservo.setUserid(((UserVO)session.getAttribute("login")).getUserid());
		uservo.setLoginApi(((UserVO)session.getAttribute("login")).getLoginApi());
		uservo=service.getUser(uservo);
		System.out.println("keyword 1 : "+uservo.getKeyword1());
		
		noticeList=service.getNotice(uservo);
		model.addAttribute("noticeList",noticeList);
		model.addAttribute("uservo",uservo);
		
		System.out.println("num : "+noticeList.size());
		for(int i=0;i<noticeList.size();i++) {
			System.out.println(noticeList.get(i).getTitle());
		}
		
		return "top/main";
	}
	
	@RequestMapping(value = "/handong/insert", method = RequestMethod.GET)
	public String insert(HttpSession session, UserVO uservo) {
		
		System.out.println(uservo.getKeyword1());
		
		uservo.setUserid(((UserVO)session.getAttribute("login")).getUserid());
		service.updateUser(uservo);
		
		return "top/insert";
	}
}

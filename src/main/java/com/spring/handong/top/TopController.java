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
		System.out.println("keyword 2 : "+uservo.getKeyword2());
		System.out.println("keyword 3 : "+uservo.getKeyword3());
		System.out.println("keyword 4 : "+uservo.getKeyword4());
		System.out.println("keyword 5 : "+uservo.getKeyword5());
		
		noticeList=service.getNotice(uservo);
		model.addAttribute("noticeList",noticeList);
		model.addAttribute("uservo",uservo);
		
		System.out.println("num : "+noticeList.size());
		for(int i=0;i<noticeList.size();i++) {
			System.out.println(noticeList.get(i).getTitle());
		}
		
		return "top/main";
	}
	
	@RequestMapping(value = "/handong/insert_ok", method = RequestMethod.GET)
	public String insert_ok(HttpSession session, UserVO uservo,Locale locale, Model model) {
		UserVO selectUserVO = new UserVO();
		
		System.out.println(uservo.getKeyword1());
		
		uservo.setUserid(((UserVO)session.getAttribute("login")).getUserid());
		uservo.setLoginApi(((UserVO)session.getAttribute("login")).getLoginApi());
		
		selectUserVO =service.getUser(uservo);
		
		System.out.println("keyword 1 : "+uservo.getKeyword1());
		System.out.println("keyword 2 : "+uservo.getKeyword2());
		System.out.println("keyword 3 : "+uservo.getKeyword3());
		System.out.println("keyword 4 : "+uservo.getKeyword4());
		System.out.println("keyword 5 : "+uservo.getKeyword5());
	
		if (selectUserVO.getKeyword1() == null)	selectUserVO.setKeyword1(uservo.getKeyword1());
		else if (selectUserVO.getKeyword2() == null)	selectUserVO.setKeyword2(uservo.getKeyword1());
		else if (selectUserVO.getKeyword3() == null)	selectUserVO.setKeyword3(uservo.getKeyword1());
		else if (selectUserVO.getKeyword4() == null)	selectUserVO.setKeyword4(uservo.getKeyword1());
		else if (selectUserVO.getKeyword5() == null)	selectUserVO.setKeyword5(uservo.getKeyword1());
		else selectUserVO.setKeyword1(uservo.getKeyword1());
		
		service.updateUser(selectUserVO);
		
		List<CrawlingVO> noticeList = new ArrayList<CrawlingVO>();
		uservo.setUserid(((UserVO)session.getAttribute("login")).getUserid());
		uservo.setLoginApi(((UserVO)session.getAttribute("login")).getLoginApi());
		uservo=service.getUser(uservo);
		
		System.out.println("keyword 1 : "+uservo.getKeyword1());
		System.out.println("keyword 2 : "+uservo.getKeyword2());
		System.out.println("keyword 3 : "+uservo.getKeyword3());
		System.out.println("keyword 4 : "+uservo.getKeyword4());
		System.out.println("keyword 5 : "+uservo.getKeyword5());
		
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

		return "top/insert";
	}
}

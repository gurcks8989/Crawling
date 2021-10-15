package com.spring.login;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import com.spring.user.UserServiceImpl;
import com.spring.user.UserVO; 

@Controller
public class LoginController {

	@Autowired
	UserServiceImpl service;
	

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String login(Model model,HttpSession session) {
		return "login/login";
	}
	
	@RequestMapping(value="/loginOk", method = RequestMethod.POST)
	public String loginCheck(HttpSession session, UserVO vo) {
		String returnURL = "" ;
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		UserVO form = service.getForm(vo) ;
		
		if(form == null) {
			System.out.println("login fail! - form data is empty");
			returnURL = "redirect:../" ;
		}
		else {
			System.out.println("API   : " + form.getLoginApi());
			System.out.println("name  : " + form.getUsername());
			System.out.println("id    : " + form.getUserid());
			System.out.println("email : " + form.getEmail());
			System.out.println("photo : " + form.getPhoto());
			
			if(!service.getIdCheck(vo))
				service.insertUser(vo) ;
			
			UserVO loginvo = service.getUSer(vo) ;

			if(loginvo != null) { 	//login success
				System.out.println("login success!") ;
				session.setAttribute("login", loginvo);
				returnURL = "redirect:../handong" ;
				
			}
			else {					// login fail
				System.out.println("login fail! - not exist user in db");
				returnURL = "redirect:../" ;
			}
		}
		return returnURL ;
	}
	
	//logout part
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../";
	}
		
}

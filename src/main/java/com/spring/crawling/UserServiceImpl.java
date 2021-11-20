package com.spring.crawling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crawling.CrawlingDAO;

public class UserServiceImpl{

	
 	UserDAO userDAO = new UserDAO(); //spring.user에 있는 user랑 다르니까 헷갈림 주의, 이름 변경 하는걸 권장함
	
	public UserVO getUser(UserVO vo) { 
		
		return userDAO.getUser(vo) ; 
	}
}

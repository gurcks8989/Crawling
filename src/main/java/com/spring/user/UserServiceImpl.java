package com.spring.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crawling.CrawlingDAO;

@Service
public class UserServiceImpl{

	UserDAO userDAO = new UserDAO();

	public UserVO getForm(UserVO vo) {
		return userDAO.getForm(vo) ;
	}
	
	public boolean getIdCheck(UserVO vo) {
		return userDAO.getIdCheck(vo) ;
	}
	
	public int insertUser(UserVO vo) {
		return userDAO.insertUser(vo) ; 	
	}

	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo) ;
	}
	
	public List<UserVO> getUserAll() {
		return userDAO.getUserAll() ;
	}
}

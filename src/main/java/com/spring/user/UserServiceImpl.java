package com.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl{

	@Autowired
	UserDAO userDAO ;

	public UserVO getForm(UserVO vo) {
		return userDAO.getForm(vo) ;
	}
	
	public boolean getIdCheck(UserVO vo) {
		return userDAO.getIdCheck(vo) ;
	}
	
	public int insertUser(UserVO vo) {
		return userDAO.insertUser(vo) ; 	
	}

	public UserVO getUSer(UserVO vo) {
		return userDAO.getUser(vo) ;
	}
}

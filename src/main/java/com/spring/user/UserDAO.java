package com.spring.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	public UserVO getForm(UserVO vo) {
		return sqlSession.selectOne("com.spring.delivery.user.getForm", vo);	
	}

	public boolean getIdCheck(UserVO vo) {
		return sqlSession.selectOne("com.spring.delivery.user.getIdCheck", vo);	
	}
	
	public int insertUser(UserVO vo) {
		return sqlSession.insert("com.spring.delivery.user.insertUser", vo) ;
	}
		
	public UserVO getUser(UserVO vo) {
		return sqlSession.selectOne("com.spring.delivery.user.getUSer", vo);	
	}
	
}

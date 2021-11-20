package com.spring.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository;

import com.spring.crawling.CrawlingVO;



@Repository
public class UserDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	public UserVO getForm(UserVO vo) {
		return sqlSession.selectOne("com.spring.user.getForm", vo);	
	}

	public boolean getIdCheck(UserVO vo) {
		return sqlSession.selectOne("com.spring.user.getIdCheck", vo);	
	}
	
	public int insertUser(UserVO vo) {
		return sqlSession.insert("com.spring.user.insertUser", vo) ;
	}
		
	public UserVO getUser(UserVO vo) {
		return sqlSession.selectOne("com.spring.user.getUser", vo);	
	}
	public List<UserVO> getUserAll() {
		return sqlSession.selectList("com.spring.user.getUser");	
	}

	public int updateUser(UserVO vo) {
		return sqlSession.update("com.spring.user.updateUser",vo);
	}

	public List<CrawlingVO> getNotice(UserVO uservo) {
		return sqlSession.selectList("com.spring.user.getNotice",uservo);
	}
}

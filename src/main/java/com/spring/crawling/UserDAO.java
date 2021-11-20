package com.spring.crawling;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.spring.crawling.CrawlingVO;

public class UserDAO {  //spring.user에 있는 user랑 다르니까 헷갈림 주의, 이름 변경 하는걸 권장함
	public UserVO getUser(UserVO vo) { 
		UserVO userVo = new UserVO();
		SqlSession sqlSession = null;
		try {
			System.out.println("start user getUser\t");
			sqlSession = sqlSessionFactory().openSession();
			
			vo.setLoginApi("Google");
			vo.setUserid("115138703312838755769");
			
			userVo = sqlSession.selectOne("com.spring.crawling.getUser", vo); 
			System.out.println(userVo.getEmail());
			return userVo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("[Exist]\t");
		}
		finally {
			if (sqlSession!=null)	sqlSession.close();
		}
			
		return userVo;
	} 
			
	
	public DriverManagerDataSource dataSource() { 
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUsername("gurcks8989");
		dataSource.setUrl("jdbc:mariadb://gurcks8989.cafe24.com/gurcks8989?autoReconnect=true");
		dataSource.setPassword("handong1");
		return dataSource;
	}

	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*-mapper.xml"));
		sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
		return sqlSessionFactory.getObject();
	}
	
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory){
		
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}

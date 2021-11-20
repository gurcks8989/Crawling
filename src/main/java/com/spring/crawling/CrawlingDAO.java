package com.spring.crawling;

import java.util.ArrayList;
//import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
//import java.sql.SQLException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CrawlingDAO {
		
	public int insertNotice(CrawlingVO vo) {
		int result=0;
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory().openSession();
			result = sqlSession.insert("com.spring.crawling.insertNotice", vo);
			System.out.print("[First]\t");
			return result ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[Exist]\t" + vo.getCategory() + "category");
		}
		finally {
			if (sqlSession!=null)	sqlSession.close();
		}
		return result ;
	}
	
	public List<CrawlingParamVO> getKeywordMatchedList(CrawlingParamVO crawlingParamVo) {
		SqlSession sqlSession = null;
		List<CrawlingParamVO> result = null ;
		try {
			sqlSession = sqlSessionFactory().openSession();
			result = sqlSession.selectList("com.spring.crawling.getKeywordMatchedList", crawlingParamVo) ;
			return result ;
		} catch (Exception e) {
			System.out.println("[Don't Find]\t" + crawlingParamVo.getTitle());
			// TODO Auto-generated catch block
		}
		finally {
			if (sqlSession!=null)	sqlSession.close();
		}
		return result ;
	}
//
//	// 글 삭제
//	public int deleteBoard(int seq) {
//		int result = sqlSession.delete("Board.deleteBoard", seq);
//		return result ;
//	}
//	
//	public int updateBoard(CrawlingVO vo) {
//		int result = sqlSession.update("Board.updateBoard", vo);
//		return result ;
//	}	
	/*
	class BoardRowMapper implements RowMapper <BoardVO>{
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO vo = new BoardVO();
			vo.setSeq(rs.getInt("seq"));
			vo.setCategory(rs.getString("category"));
			vo.setTitle(rs.getString("title"));
			vo.setWriter(rs.getString("writer"));
			vo.setContent(rs.getString("content"));
			vo.setCnt(rs.getInt("cnt"));
			return vo ;
		}
	}
	*/
	
	/*
	 * public CrawlingVO getBoard(int seq) { CrawlingVO result =
	 * sqlSession.selectOne("Board.getBoard", seq); return result ; }
	 * 
	 * 
	 * public List<CrawlingVO> getBoardList(){ List<CrawlingVO> result =
	 * sqlSession.selectList("Board.getBoardList"); return result ; }
	 */
	
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

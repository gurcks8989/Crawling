package com.spring.crawling;

//import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
//import java.sql.SQLException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CrawlingDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public int insertNotice(CrawlingVO vo) {
		int result = sqlSession.insert("com.spring.crawling.insertNotice", vo);
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
	
	public CrawlingVO getBoard(int seq) {
		CrawlingVO result = sqlSession.selectOne("Board.getBoard", seq);
		return result ;
	}
	
	
	public List<CrawlingVO> getBoardList(){
		List<CrawlingVO> result = sqlSession.selectList("Board.getBoardList");
		return result ;
	}
}

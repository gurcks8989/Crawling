package com.spring.delivery.food;

//import java.sql.ResultSet;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
//import java.sql.SQLException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int insertFood(FoodVO vo) {
		int result = sqlSession.insert("Food.insertFood", vo);
		return result ;
	}

	// 글 삭제
	public int deleteFood(int seq) {
		int result = sqlSession.delete("Food.deleteFood", seq);
		return result ;
	}
	
	public int updateFood(FoodVO vo) {
		int result = sqlSession.update("Food.updateFood", vo);
		return result ;
	}	
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
	
	public FoodVO getFood(int seq) {
		FoodVO result = sqlSession.selectOne("Food.getFood", seq);
		return result ;
	}
	
	
	public List<FoodVO> getFoodList(){
		List<FoodVO> result = sqlSession.selectList("Food.getFoodList");
		return result ;
	}
}

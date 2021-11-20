package com.spring.crawling;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

public class CrawlingServiceImpl implements CrawlingService{

	
	CrawlingDAO crawlingDAO = new CrawlingDAO();
	
	@Override
	public int insertNotice(CrawlingVO vo) {
		return crawlingDAO.insertNotice(vo);
	}
	
	@Override
	public List<CrawlingParamVO> getKeywordMatchedList(CrawlingParamVO crawlingParamVo){
		return crawlingDAO.getKeywordMatchedList(crawlingParamVo) ;
	}
//	@Override
//	public int deleteBoard(int seq) {
//		return boardDAO.deleteBoard(seq) ;
//	}
//	
//	@Override
//	public int updateBoard(BoardVO vo) {
//		return boardDAO.updateBoard(vo) ;
//	}
//	
//	@Override
//	public BoardVO getBoard(int seq) {
//		return boardDAO.getBoard(seq) ;
//	}
//	
//	@Override
//	public List<BoardVO> getBoardList() {
//		return boardDAO.getBoardList() ;
//	}
}

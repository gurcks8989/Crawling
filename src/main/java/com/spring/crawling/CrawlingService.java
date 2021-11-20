package com.spring.crawling;
import java.util.List ;

public interface CrawlingService {
	public int insertNotice(CrawlingVO vo);
	public List<CrawlingParamVO> getKeywordMatchedList(CrawlingParamVO crawlingParamVo);
//	public int deleteBoard(int seq) ;
//	public int updateBoard(BoardVO vo);
//	public BoardVO getBoard(int seq);
//	public List<BoardVO> getBoardList() ;
}

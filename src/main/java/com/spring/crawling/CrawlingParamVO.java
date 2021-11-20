package com.spring.crawling;

import java.sql.Timestamp;

public class CrawlingParamVO extends UserVO{
	private int seq;
	private String category;
	private String noticeNum;
	private String title;
	private String link;
	private Timestamp ctime;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(String noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Timestamp getCtime() {
		return ctime;
	}
	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}
}

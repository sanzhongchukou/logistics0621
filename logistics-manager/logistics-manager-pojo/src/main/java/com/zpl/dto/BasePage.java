package com.zpl.dto;

public class BasePage {
	//当前页
	protected Integer pageNum = 1;
	//每页显示条数
	protected Integer pageSize = 5;
	protected String keyword;
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}

package com.ssafy.happyhouse.dto;

import java.util.List;

public class SchoolResultDto {
	private int result;
	private List<SchoolDto> list;
	private int cnt;
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public List<SchoolDto> getList() {
		return list;
	}
	public void setList(List<SchoolDto> list) {
		this.list = list;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}

package com.ssafy.happyhouse.dto;

public class DealParamDto {
	private String searchWord;
	private int userSeq;
	private int limit;
	private int offset;

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "DealParamDto [searchWord=" + searchWord + ", userSeq=" + userSeq + ", limit=" + limit + ", offset="
				+ offset + "]";
	}

}

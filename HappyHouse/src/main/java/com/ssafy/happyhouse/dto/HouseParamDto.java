package com.ssafy.happyhouse.dto;

public class HouseParamDto {
	private int limit;
	private int offset;
	private String searchWord;
	private int userSeq;
	private String searchType;

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

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	@Override
	public String toString() {
		return "HouseParamDto [limit=" + limit + ", offset=" + offset + ", searchWord=" + searchWord + ", userSeq="
				+ userSeq + ", searchType=" + searchType + "]";
	}

}

package com.ssafy.happyhouse.service;

public interface BookmarkService {
	public int insertBookmark(int userSeq, int dealNo);

	public int deleteBookmark(int userSeq, int dealNo);

	public boolean checkBookmark(int userSeq, int dealNo);
}

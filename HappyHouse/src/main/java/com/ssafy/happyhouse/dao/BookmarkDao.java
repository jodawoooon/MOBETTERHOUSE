package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.BookmarkDto;
@Mapper
public interface BookmarkDao {
	public int insertBookmark(int userSeq, int dealNo);
	public int deleteBookmark(int userSeq, int dealNo);
	
	public List<BookmarkDto> bookmarkList(int limit, int offset);
	public int bookmarkListTotalCnt();
	
	public boolean checkBookmark(int userSeq, int dealNo);
}

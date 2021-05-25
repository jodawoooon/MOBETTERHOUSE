package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.BookmarkAreaDto;
import com.ssafy.happyhouse.dto.BookmarkDto;
import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseParamDto;

public interface HouseService {
	public List<HouseDto> houseList(HouseParamDto param);

	public int houseListTotalCount();

	public List<HouseDto> houseSearchDong(HouseParamDto param);

	public int houseSearchDongTotalCount(String searchWord);

	public List<HouseDto> houseSearchApt(HouseParamDto param);

	public int houseSearchAptTotalCount(String searchWord);

	public List<Map<String, String>> sidoList();

	public List<Map<String, String>> gugunList(String sidoCode);

	public List<Map<String, String>> dongList(Map<String, String> map);

	public int insertBookmark(BookmarkDto bookmarkDto);

	public int deleteBookmark(BookmarkDto bookmarkDto);

	public int insertBookmarkArea(BookmarkAreaDto bookmarkAreaDto);

	public int deleteBookmarkArea(BookmarkAreaDto bookmarkAreaDto);

	public boolean getBookmarkArea(BookmarkAreaDto bookmarkAreaDto);

	public List<HouseDto> bookmarkHouse(HouseParamDto param);

	public int bookmarkHouseTotalCount(int userSeq);

	public List<HouseDto> bookmarkArea(HouseParamDto param);

	public int bookmarkAreaTotalCount(HouseParamDto param);
	
	public List<HouseDto> bookmarkAreaInit(HouseParamDto param);

	public int bookmarkAreaInitTotalCount(int userSeq);

	public List<Map<String, String>> sidoListBookmarkArea(int userSeq);

	public List<Map<String, String>> gugunListBookmarkArea(Map<String, String> map);

	public List<Map<String, String>> dongListBookmarkArea(Map<String, String> map);
}

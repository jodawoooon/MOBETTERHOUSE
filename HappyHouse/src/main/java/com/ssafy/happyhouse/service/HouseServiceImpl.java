package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HouseDao;
import com.ssafy.happyhouse.dto.BookmarkAreaDto;
import com.ssafy.happyhouse.dto.BookmarkDto;
import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseParamDto;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	HouseDao houseDao;

	@Override
	public List<HouseDto> houseList(HouseParamDto param) {
		return houseDao.houseList(param);
	}

	@Override
	public int houseListTotalCount() {
		return houseDao.houseListTotalCount();
	}

	@Override
	public List<HouseDto> houseSearchDong(HouseParamDto param) {
		return houseDao.houseSearchDong(param);
	}

	@Override
	public int houseSearchDongTotalCount(String searchWord) {
		return houseDao.houseSearchDongTotalCount(searchWord);
	}

	@Override
	public List<HouseDto> houseSearchApt(HouseParamDto param) {
		return houseDao.houseSearchApt(param);
	}

	@Override
	public int houseSearchAptTotalCount(String searchWord) {
		return houseDao.houseSearchAptTotalCount(searchWord);
	}

	@Override
	public List<Map<String, String>> sidoList() {
		return houseDao.sidoList();
	}

	@Override
	public List<Map<String, String>> gugunList(String sidoCode) {
		return houseDao.gugunList(sidoCode);
	}

	@Override
	public List<Map<String, String>> dongList(Map<String, String> map) {
		return houseDao.dongList(map);
	}

	@Override
	public int insertBookmark(BookmarkDto bookmarkDto) {
		return houseDao.insertBookmark(bookmarkDto);
	}

	@Override
	public int deleteBookmark(BookmarkDto bookmarkDto) {
		return houseDao.deleteBookmark(bookmarkDto);
	}
	
	@Override
	public int insertBookmarkArea(BookmarkAreaDto bookmarkAreaDto) {
		return houseDao.insertBookmarkArea(bookmarkAreaDto);
	}

	@Override
	public int deleteBookmarkArea(BookmarkAreaDto bookmarkAreaDto) {
		return houseDao.deleteBookmarkArea(bookmarkAreaDto);
	}
	
	@Override
	public boolean getBookmarkArea(BookmarkAreaDto bookmarkAreaDto) {
		return houseDao.getBookmarkArea(bookmarkAreaDto);
	}
	
	@Override
	public List<HouseDto> bookmarkHouse(HouseParamDto param) {
		return houseDao.bookmarkHouse(param);
	}

	@Override
	public int bookmarkHouseTotalCount(int userSeq) {
		return houseDao.bookmarkHouseTotalCount(userSeq);
	}
	
	@Override
	public List<HouseDto> bookmarkArea(HouseParamDto param) {
		return houseDao.bookmarkArea(param);
	}

	@Override
	public int bookmarkAreaTotalCount(HouseParamDto param) {
		return houseDao.bookmarkAreaTotalCount(param);
	}
	
	@Override
	public List<HouseDto> bookmarkAreaInit(HouseParamDto param) {
		return houseDao.bookmarkAreaInit(param);
	}

	@Override
	public int bookmarkAreaInitTotalCount(int userSeq) {
		return houseDao.bookmarkAreaInitTotalCount(userSeq);
	}

	@Override
	public List<Map<String, String>> sidoListBookmarkArea(int userSeq) {
		return houseDao.sidoListBookmarkArea(userSeq);
	}

	@Override
	public List<Map<String, String>> gugunListBookmarkArea(Map<String, String> map) {
		return houseDao.gugunListBookmarkArea(map);
	}

	@Override
	public List<Map<String, String>> dongListBookmarkArea(Map<String, String> map) {
		return houseDao.dongListBookmarkArea(map);
	}
}

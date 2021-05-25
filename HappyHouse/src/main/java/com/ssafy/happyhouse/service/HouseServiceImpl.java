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
		System.out.println("/insertBookmark!!!!");
		int ret = houseDao.insertBookmark(bookmarkDto);
		System.out.println("ret : " + ret);
		return ret;
	}

	@Override
	public int deleteBookmark(BookmarkDto bookmarkDto) {
		System.out.println("/deleteBookmark!!!!");
		int ret = houseDao.deleteBookmark(bookmarkDto);
		System.out.println("ret : " + ret);
		return ret;
	}
	
	@Override
	public int insertBookmarkArea(BookmarkAreaDto bookmarkAreaDto) {
		System.out.println("/insertBookmark!!!!");
		int ret = houseDao.insertBookmarkArea(bookmarkAreaDto);
		System.out.println("ret : " + ret);
		return ret;
	}

	@Override
	public int deleteBookmarkArea(BookmarkAreaDto bookmarkAreaDto) {
		System.out.println("/deleteBookmark!!!!");
		int ret = houseDao.deleteBookmarkArea(bookmarkAreaDto);
		System.out.println("ret : " + ret);
		return ret;
	}
	
	@Override
	public boolean getBookmarkArea(BookmarkAreaDto bookmarkAreaDto) {
		System.out.println("/getBookmark!!!!");
		boolean ret = houseDao.getBookmarkArea(bookmarkAreaDto);
		System.out.println("ret : " + ret);
		return ret;
	}
}

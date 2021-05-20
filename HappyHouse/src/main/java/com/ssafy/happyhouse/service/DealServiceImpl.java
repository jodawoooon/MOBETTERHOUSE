package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.DealDao;
import com.ssafy.happyhouse.dto.DealDto;
import com.ssafy.happyhouse.dto.DealParamDto;

@Service
public class DealServiceImpl implements DealService {

	private static DealServiceImpl instance;

	private DealServiceImpl() {
	}

	public static DealServiceImpl getInstance() {
		if (instance == null) {
			instance = new DealServiceImpl();
		}

		return instance;
	}

	@Autowired
	DealDao dealDao;

	@Override
	public DealDto dealDetail(int dealId) {
		return dealDao.dealDetail(dealId);
	}

	@Override
	public List<DealDto> dealList(Map<String, Integer> map) {
		System.out.println("==========DealService==========");
		map.forEach((k, v) -> System.out.println(k + " : " + v));
		List<DealDto> list = dealDao.dealList(map);
		list.forEach(dto -> System.out.println(dto));
		return list;
	}

	@Override
	public int dealListTotalCnt() {
		int ret = dealDao.dealListTotalCnt();
		System.out.println("==========DealService==========");
		System.out.println("ret : " + ret);
		return ret;
	}

	@Override
	public List<DealDto> dealListSearchDong(DealParamDto paramDto) {
		List<DealDto> list = dealDao.dealListSearchDong(paramDto);
		System.out.println("==========DealService==========");
		list.forEach(dto -> System.out.println(dto));
		return list;
	}

	@Override
	public int dealListSearchDongTotalCnt(String searchDong) {
		int ret = dealDao.dealListSearchDongTotalCnt(searchDong);
		System.out.println("==========DealService==========");
		System.out.println("ret : " + ret);
		return ret;
	}

	@Override
	public List<DealDto> dealListSearchApt(DealParamDto paramDto) {
		List<DealDto> list = dealDao.dealListSearchApt(paramDto);
		System.out.println("==========DealService==========");
		list.forEach(dto -> System.out.println(dto));
		return list;
	}

	@Override
	public int dealListSearchAptTotalCnt(String searchApt) {
		int ret = dealDao.dealListSearchAptTotalCnt(searchApt);
		System.out.println("==========DealService==========");
		System.out.println("ret : " + ret);
		return ret;
	}

	@Override
	public List<DealDto> dealListBookmark(int limit, int offset, int userSeq) {
		return dealDao.dealListBookmark(limit, offset, userSeq);
	}

	@Override
	public int dealListBookmarkTotalCnt(int userSeq) {
		return dealDao.dealListBookmarkTotalCnt(userSeq);
	}

}

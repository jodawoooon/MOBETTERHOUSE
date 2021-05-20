package com.ssafy.happyhouse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.SearchDao;
import com.ssafy.happyhouse.dto.SearchDto;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchDao dao;

	private static SearchServiceImpl instance;

	private SearchServiceImpl() {

	}

	public static SearchServiceImpl getInstance() {
		if (instance == null)
			instance = new SearchServiceImpl();
		return instance;
	}

	@Override
	public List<SearchDto> sidoList() {
		List<String> listTemp = dao.sidoList();
		List<SearchDto> list = new ArrayList<SearchDto>();
		System.out.println("==========sidoList==========");
		for (String str : listTemp) {
			System.out.println(str);
			SearchDto push = new SearchDto();
			push.setSidoName(str);
			list.add(push);
		}
		return list;
	}

	@Override
	public List<SearchDto> gugunList(String sidoName) {
		List<String> listTemp = dao.gugunList(sidoName);
		List<SearchDto> list = new ArrayList<SearchDto>();
		System.out.println("==========gugunList==========");
		for (String str : listTemp) {
			System.out.println(str);
			SearchDto push = new SearchDto();
			push.setSidoName(sidoName);
			push.setGugunName(str);
			list.add(push);
		}
		return list;
	}

	@Override
	public List<SearchDto> dongList(String sidoName, String gugunName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sidoName", sidoName);
		map.put("gugunName", gugunName);
		List<String> listTemp = dao.dongList(map);
		List<SearchDto> list = new ArrayList<SearchDto>();
		System.out.println("==========dongList==========");
		for (String str : listTemp) {
			System.out.println(str);
			SearchDto push = new SearchDto();
			push.setSidoName(sidoName);
			push.setGugunName(gugunName);
			push.setDongName(str);
			list.add(push);
		}
		return list;
	}

}

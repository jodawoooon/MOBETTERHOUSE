package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HouseDao;
import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseParamDto;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	HouseDao houseDao;
	
	@Override
	public List<HouseDto> houseList(HouseParamDto param){
		return houseDao.houseList(param);
	}
	
	@Override
	public int houseListTotalCount() {
		return houseDao.houseListTotalCount();
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
	public List<Map<String,String>> sidoList() {
		return houseDao.sidoList();
	}
	
	@Override
	public List<Map<String,String>> gugunList(String sidoCode) {
		return houseDao.gugunList(sidoCode);
	}
	
	@Override
	public List<Map<String,String>> dongList(Map<String,String> map) {
		return houseDao.dongList(map);
	}
}

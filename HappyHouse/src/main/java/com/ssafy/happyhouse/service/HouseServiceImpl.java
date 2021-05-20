package com.ssafy.happyhouse.service;

import java.util.List;

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
}

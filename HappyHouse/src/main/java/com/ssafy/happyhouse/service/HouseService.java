package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseParamDto;

public interface HouseService {
	public List<HouseDto> houseList(HouseParamDto param);
}

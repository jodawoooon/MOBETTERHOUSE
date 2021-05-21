package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseParamDto;

@Mapper
public interface HouseDao {
	public List<HouseDto> houseList(HouseParamDto param);

	public int houseListTotalCount();

	public List<HouseDto> houseSearchApt(HouseParamDto param);

	public int houseSearchAptTotalCount(String searchWord);
}
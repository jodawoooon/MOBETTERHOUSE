package com.ssafy.happyhouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseParamDto;

@Mapper
public interface HouseDao {
	public List<HouseDto> houseList(HouseParamDto param);

	public int houseListTotalCount();

	public List<HouseDto> houseSearchApt(HouseParamDto param);

	public int houseSearchAptTotalCount(String searchWord);

	public List<Map<String,String>> sidoList();
	
	public List<Map<String,String>> gugunList(String sidoCode);
	
	public List<Map<String,String>> dongList(Map<String,String> map);
}
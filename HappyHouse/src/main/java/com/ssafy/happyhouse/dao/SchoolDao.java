package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.SchoolDto;

@Mapper
public interface SchoolDao {
	public List<SchoolDto> schoolList(String dongName);
	public int schoolListCnt(String dongName);
	
}

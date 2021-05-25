package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.InfoDto;


@Mapper
public interface InfoDao {
	public InfoDto guInfo(String guName);
	public InfoDto getAvg();
}

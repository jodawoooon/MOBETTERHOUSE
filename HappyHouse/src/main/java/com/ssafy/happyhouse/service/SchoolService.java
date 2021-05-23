package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.SchoolDto;

public interface SchoolService {
	public List<SchoolDto> schoolList(String dongName);
	public int schoolListCnt(String dongName);
	
}

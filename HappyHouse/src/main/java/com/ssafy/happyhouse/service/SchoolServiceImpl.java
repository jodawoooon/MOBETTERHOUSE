package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.SchoolDao;
import com.ssafy.happyhouse.dto.SchoolDto;

@Service
public class SchoolServiceImpl implements SchoolService {

	
	@Autowired
	SchoolDao schoolDao;
	
	@Override
	public List<SchoolDto> schoolList(String dongName) {
		
		return schoolDao.schoolList(dongName);
	}

	@Override
	public int schoolListCnt(String dongName) {
		
		return schoolDao.schoolListCnt(dongName);
	}

}

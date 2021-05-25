package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.InfoDao;
import com.ssafy.happyhouse.dto.InfoDto;


@Service
public class InfoServiceImpl implements InfoService {
	
	@Autowired
	InfoDao infoDao;

	@Override
	public InfoDto guInfo(String guName) {
		
		return infoDao.guInfo(guName);
	}

	@Override
	public InfoDto getAvg() {
		
		return infoDao.getAvg();
	}
	
	

}

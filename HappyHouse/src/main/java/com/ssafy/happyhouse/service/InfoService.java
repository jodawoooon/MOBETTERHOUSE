package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.InfoDto;

public interface InfoService {
	public InfoDto guInfo(String guName);
	public InfoDto getAvg();
}

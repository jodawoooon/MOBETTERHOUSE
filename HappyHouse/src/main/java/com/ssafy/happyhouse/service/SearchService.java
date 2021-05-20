package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.SearchDto;

public interface SearchService {
	public List<SearchDto> sidoList();

	public List<SearchDto> gugunList(String sidoName);

	public List<SearchDto> dongList(String sidoName, String gugunName);
}

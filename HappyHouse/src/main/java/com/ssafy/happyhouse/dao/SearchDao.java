package com.ssafy.happyhouse.dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchDao {
	public List<String> sidoList();

	public List<String> gugunList(String sidoName);

	public List<String> dongList(Map<String, String> map);
}


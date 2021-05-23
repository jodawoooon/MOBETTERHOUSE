package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.CodeDto;


@Mapper
public interface CodeDao {
	public List<CodeDto> codeList(String groupCode);
}

package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.ssafy.happyhouse.dto.UserDto;

@Mapper
public interface UserDao {
	public List<UserDto> boardList();
	
}

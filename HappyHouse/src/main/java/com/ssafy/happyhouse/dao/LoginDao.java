package com.ssafy.happyhouse.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.UserDto;


@Mapper
public interface LoginDao {
	public UserDto login(String userEmail);
}

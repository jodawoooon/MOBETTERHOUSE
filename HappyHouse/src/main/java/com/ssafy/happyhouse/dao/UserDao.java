package com.ssafy.happyhouse.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.UserDto;

@Mapper
public interface UserDao {
	public int userRegister(UserDto userDto);
	public int userEdit(UserDto userDto);
	public UserDto userFindPass(UserDto userDto);
	public int userSecession(UserDto userDto);
	public UserDto userInfo(UserDto userDto);
	
}

package com.ssafy.happyhouse.service;


import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.UserResultDto;

public interface UserService {
	public UserDto userRegister(UserDto userDto);
	public UserResultDto userEdit(UserDto userDto);
	public UserDto userFindPass(UserDto userDto);
	public UserResultDto userSecession(UserDto userDto);
	public UserDto userInfo(String userEmail);
}

package com.ssafy.happyhouse.service;


import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.UserResultDto;

public interface UserService {
	public UserDto userRegister(UserDto userDto);
	public UserDto userEdit(UserDto userDto);
	public UserDto userFindPass(String userEmail);
	public UserResultDto userSecession(String userEmail);
	public UserDto userInfo(String userEmail);
}

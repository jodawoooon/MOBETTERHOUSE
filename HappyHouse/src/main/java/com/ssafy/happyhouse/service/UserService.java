package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserService {
	public int userRegister(UserDto userDto);
	public int userEdit(UserDto userDto);
	public UserDto userFindPass(UserDto userDto);
	public int userSecession(UserDto userDto);
	public UserDto userInfo(UserDto userDto);
}

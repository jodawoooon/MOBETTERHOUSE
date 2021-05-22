package com.ssafy.happyhouse.service;


import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.UserResultDto;

public interface UserService {
	public UserDto userRegister(UserDto userDto);
	public UserDto userEdit(UserDto userDto);
	public UserDto userFindPass(String userEmail);
	public UserResultDto userSecession(String userEmail);
	public UserDto userInfo(String userEmail);
	public UserDto insertUserProfileImage(UserDto userDto, MultipartHttpServletRequest request);
}

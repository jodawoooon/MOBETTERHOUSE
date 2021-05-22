package com.ssafy.happyhouse.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.happyhouse.dto.UserDto;

@Mapper
public interface UserDao {
	public int userRegister(UserDto userDto);
	public int userEdit(UserDto userDto);
	public UserDto userFindPass(String userEmail);
	public int userSecession(String userEmail);
	public UserDto userInfo(String userEmail);
	public int insertUserProfileImage(UserDto userDto);
}

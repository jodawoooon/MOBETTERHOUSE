package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.UserDao;
import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.UserResultDto;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;
	
	@Override
	public UserDto userRegister(UserDto userDto) {
		
		if( userDto != null && userDao.userRegister(userDto) == 1 ) {
			return userDto;
		}else {
			return null;
		}
		
	}
	
	@Override
	public UserDto userEdit(UserDto userDto) {
		
		if( userDto != null && userDao.userEdit(userDto) == 1 ) {
			return userDto;
		}else {
			return null;
		}
		
	}
	
	@Override
	public UserDto userFindPass(String userEmail) {
		// TODO Auto-generated method stub
		return userDao.userFindPass(userEmail);
	}
	
	@Override
	public UserResultDto userSecession(String userEmail) {
		UserResultDto userResultDto = new UserResultDto();
		if( userDao.userSecession(userEmail) == 1 ) {
			userResultDto.setResult(SUCCESS);
		}else {
			userResultDto.setResult(FAIL);
		}
		
		return userResultDto;
	}
	
	@Override
	public UserDto userInfo(String userEmail) {
		// TODO Auto-generated method stub
		return userDao.userInfo(userEmail);
	}
	
}

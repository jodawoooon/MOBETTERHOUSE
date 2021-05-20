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
	public UserResultDto userRegister(UserDto userDto) {
		UserResultDto userResultDto = new UserResultDto();
		if( userDao.userRegister(userDto) == 1 ) {
			userResultDto.setResult(SUCCESS);
		}else {
			userResultDto.setResult(FAIL);
		}
		
		return userResultDto;
	}
	
	@Override
	public UserResultDto userEdit(UserDto userDto) {
		UserResultDto userResultDto = new UserResultDto();
		if( userDao.userEdit(userDto) == 1 ) {
			userResultDto.setResult(SUCCESS);
		}else {
			userResultDto.setResult(FAIL);
		}
		
		return userResultDto;
	}
	
	@Override
	public UserDto userFindPass(UserDto userDto) {
		// TODO Auto-generated method stub
		return userDao.userFindPass(userDto);
	}
	
	@Override
	public UserResultDto userSecession(UserDto userDto) {
		UserResultDto userResultDto = new UserResultDto();
		if( userDao.userSecession(userDto) == 1 ) {
			userResultDto.setResult(SUCCESS);
		}else {
			userResultDto.setResult(FAIL);
		}
		
		return userResultDto;
	}
	
	@Override
	public UserDto userInfo(UserDto userDto) {
		// TODO Auto-generated method stub
		return userDao.userInfo(userDto);
	}
	
}

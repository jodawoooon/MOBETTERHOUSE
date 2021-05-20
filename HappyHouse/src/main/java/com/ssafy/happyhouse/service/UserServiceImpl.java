package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.UserDao;
import com.ssafy.happyhouse.dto.UserDto;

@Primary
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	
	@Override
	public int userRegister(UserDto userDto) {
		
		return userDao.userRegister(userDto);
	}

	@Override
	public int userEdit(UserDto userDto) {
		
		return userDao.userEdit(userDto);
	}

	@Override
	public UserDto userFindPass(UserDto userDto) {
		// TODO Auto-generated method stub
		return userDao.userFindPass(userDto);
	}

	@Override
	public int userSecession(UserDto userDto) {
		// TODO Auto-generated method stub
		return userDao.userSecession(userDto);
	}

	@Override
	public UserDto userInfo(UserDto userDto) {
		// TODO Auto-generated method stub
		return userDao.userInfo(userDto);
	}

}

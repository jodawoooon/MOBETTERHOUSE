package com.ssafy.happyhouse.service;

import java.util.List;

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
	public List<UserDto> boardList() {
		
		return userDao.boardList();
	}
	
}

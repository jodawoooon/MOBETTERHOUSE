package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.LoginDao;
import com.ssafy.happyhouse.dto.UserDto;

@Primary
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public UserDto login(UserDto dto) {

		return loginDao.login(dto);
	}

}
package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.CodeDao;
import com.ssafy.happyhouse.dto.CodeDto;

@Service
public class CodeServiceImpl implements CodeService{
	
	@Autowired
	CodeDao codeDao;
	
	@Override
	public List<CodeDto> codeList(String groupCode) {
		System.out.println("groupCode : " + groupCode);
		System.out.println("왜안대애애애애!!~~~~~~====================");
		return codeDao.codeList(groupCode);
	}
}
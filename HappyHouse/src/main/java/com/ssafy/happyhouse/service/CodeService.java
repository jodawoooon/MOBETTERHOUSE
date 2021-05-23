package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.CodeDto;

public interface CodeService {
	public List<CodeDto> codeList(String groupCode);
}

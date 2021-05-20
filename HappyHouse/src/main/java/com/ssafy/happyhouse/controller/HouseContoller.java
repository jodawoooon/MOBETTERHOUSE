package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseParamDto;
import com.ssafy.happyhouse.service.HouseService;

@RestController
public class HouseContoller {
	
	@Autowired
	HouseService houseService;
	
	@GetMapping("/house")
	public ResponseEntity<List<HouseDto>> houseList(){
		System.out.println("/house!!!!");
		HouseParamDto param = new HouseParamDto();
		param.setLimit(10);
		param.setOffset(0);
		
		List<HouseDto> ret = houseService.houseList(param);
		for(HouseDto dto : ret) {
			System.out.println(dto);
		}
		return null;
	}
}

package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseParamDto;
import com.ssafy.happyhouse.dto.HouseResultDto;
import com.ssafy.happyhouse.service.HouseService;

@RestController
public class HouseContoller {

	@Autowired
	HouseService houseService;

	@GetMapping("/house")
	public HouseResultDto houseList() {
		System.out.println("/house!!!!");
		HouseParamDto param = new HouseParamDto();
		param.setLimit(10);
		param.setOffset(0);

		HouseResultDto result = new HouseResultDto();
		List<HouseDto> list = houseService.houseList(param);
		int count = houseService.houseListTotalCount();
		if (list != null) {
			result.setResult(1);
			result.setList(list);
			result.setCount(count);

			for (HouseDto dto : list) {
				System.out.println(dto);
			}
			System.out.println("count : " + count);
		}else {
			result.setResult(0);
		}
		return result;
	}
}

package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseParamDto;
import com.ssafy.happyhouse.dto.HouseResultDto;
import com.ssafy.happyhouse.service.HouseService;

//BoardFileUploadSpringBootMybatis 대비 @CrossOrign 추가 <-- vue cli mode 개발 대응
@CrossOrigin(origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
				RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS })
//@CrossOrigin // 이것만으로는 오류 발생 <-- allowCredentials = "true"
@RestController
public class HouseContoller {

	@Autowired
	HouseService houseService;

	@GetMapping("/house")
	public HouseResultDto houseList(@RequestParam int limit, @RequestParam int offset) {
		System.out.println("/houseList!!!!");
		HouseParamDto param = new HouseParamDto();
		param.setLimit(limit);
		param.setOffset(offset);

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
		} else {
			result.setResult(0);
		}
		return result;
	}

	@GetMapping("/house/{searchWord}")
	public HouseResultDto houseSearchApt(@PathVariable String searchWord) {
		System.out.println("/houseSearchApt!!!");
		HouseParamDto param = new HouseParamDto();
		param.setLimit(10);
		param.setOffset(0);
		param.setSearchWord(searchWord);

		HouseResultDto result = new HouseResultDto();
		List<HouseDto> list = houseService.houseSearchApt(param);
		int count = houseService.houseSearchAptTotalCount(searchWord);
		if (list != null) {
			result.setResult(1);
			result.setList(list);
			result.setCount(count);

			for (HouseDto dto : list) {
				System.out.println(dto);
			}
			System.out.println("count : " + count);
		} else {
			result.setResult(0);
		}
		return result;
	}
}

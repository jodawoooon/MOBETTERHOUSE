package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public HouseResultDto houseList(int limit, int offset, String searchWord, String searchType) {
		System.out.println("/house1!!!!!!");
		HouseParamDto param = new HouseParamDto();
		param.setLimit(limit);
		param.setOffset(offset);

		HouseResultDto result = new HouseResultDto();
		if (searchWord.equals("")) {
			System.out.println("/house2!!!!!!");
			List<HouseDto> list = houseService.houseList(param);
			for (HouseDto dto : list)
				System.out.println(dto);
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
		} else if (searchType.equals("dong")) {
			System.out.println("/house searchDong!!!!");
			param.setSearchWord(searchWord);
			List<HouseDto> list = houseService.houseSearchDong(param);
			for (HouseDto dto : list)
				System.out.println(dto);
			int count = houseService.houseSearchDongTotalCount(searchWord);
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
		}
		return result;
	}

//	@GetMapping("/house/{")
//	public HouseResultDto houseSearchApt(@RequestParam String searchWord) {
//		System.out.println("/houseSearchApt!!!");
//		HouseParamDto param = new HouseParamDto();
//		param.setLimit(10);
//		param.setOffset(0);
//		param.setSearchWord(searchWord);
//
//		HouseResultDto result = new HouseResultDto();
//		List<HouseDto> list = houseService.houseSearchApt(param);
//		int count = houseService.houseSearchAptTotalCount(searchWord);
//		if (list != null) {
//			result.setResult(1);
//			result.setList(list);
//			result.setCount(count);
//
//			for (HouseDto dto : list) {
//				System.out.println(dto);
//			}
//			System.out.println("count : " + count);
//		} else {
//			result.setResult(0);
//		}
//		return result;
//	}

	@GetMapping("/sido")
	public ResponseEntity<List<Map<String, String>>> sidoList() {
		System.out.println("/sidoList!!!");
		List<Map<String, String>> ret = houseService.sidoList();
		if (ret.isEmpty() || ret == null) {
			return new ResponseEntity<List<Map<String, String>>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			for (Map<String, String> sido : ret) {
				System.out.println(sido);
			}
			return new ResponseEntity<List<Map<String, String>>>(ret, HttpStatus.OK);
		}
	}

	@GetMapping("/gugun")
	public ResponseEntity<List<Map<String, String>>> gugunList(String sidoCode) {
		System.out.println("/gugunList!!!!");
		System.out.println(sidoCode);
		List<Map<String, String>> ret = houseService.gugunList(sidoCode);
		if (ret.isEmpty() || ret == null) {
			return new ResponseEntity<List<Map<String, String>>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			for (Map<String, String> gugun : ret) {
				System.out.println(gugun);
			}
			return new ResponseEntity<List<Map<String, String>>>(ret, HttpStatus.OK);
		}
	}

	@GetMapping("/dong")
	public ResponseEntity<List<Map<String, String>>> dongList(String sidoCode, String gugunCode) {
		System.out.println("/dongList!!!!");
		System.out.println(sidoCode + " / " + gugunCode);

		Map<String, String> map = new HashMap<String, String>();
		map.put("sidoCode", sidoCode);
		map.put("gugunCode", gugunCode);

		List<Map<String, String>> ret = houseService.dongList(map);
		if (ret.isEmpty() || ret == null) {
			return new ResponseEntity<List<Map<String, String>>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			for (Map<String, String> dong : ret) {
				System.out.println(dong);
			}
			return new ResponseEntity<List<Map<String, String>>>(ret, HttpStatus.OK);
		}
	}
}

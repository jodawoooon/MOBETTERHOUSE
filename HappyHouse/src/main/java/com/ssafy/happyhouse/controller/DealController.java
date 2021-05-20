package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.DealDto;
import com.ssafy.happyhouse.dto.DealParamDto;
import com.ssafy.happyhouse.service.DealService;

@RestController
public class DealController {

	@Autowired
	DealService dealService;

	@GetMapping("/deal")
	public ResponseEntity<List<DealDto>> dealList(@RequestParam("limit") String strLimit,
			@RequestParam("offset") String strOffset, @RequestParam String searchWord,
			@RequestParam("userSeq") String strUserSeq, @RequestParam String searchType) {
		int limit = Integer.parseInt(strLimit);
		int offset = Integer.parseInt(strOffset);
		int userSeq = Integer.parseInt(strUserSeq);
		System.out.println("==========DealController==========");
		System.out.println("limit : " + limit);
		System.out.println("offset : " + offset);

		List<DealDto> dealList = null;

		System.out.println("searchType : " + searchType);
		System.out.println("searchWord : " + searchWord);
		if ("apt".equals(searchType)) {
			if ("".equals(searchWord)) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("limit", limit);
				map.put("offset", offset);
				dealList = dealService.dealList(map);
				return new ResponseEntity<List<DealDto>>(dealList, HttpStatus.OK);
			} else {
				DealParamDto dto = new DealParamDto();
				dto.setLimit(limit);
				dto.setOffset(offset);
				dto.setSearchWord(searchWord);
				dealList = dealService.dealListSearchApt(dto);
				return new ResponseEntity<List<DealDto>>(dealList, HttpStatus.OK);
			}
		} else if ("dong".equals(searchType)) {
			DealParamDto dto = new DealParamDto();
			dto.setLimit(limit);
			dto.setOffset(offset);
			dto.setSearchWord(searchWord);
			dealList = dealService.dealListSearchDong(dto);
			return new ResponseEntity<List<DealDto>>(dealList, HttpStatus.OK);
		} else if ("bookmark".equals(searchType)) {
			dealList = dealService.dealListBookmark(limit, offset, userSeq);
		}
		return null;
	}

	@GetMapping("/deal/dealListTotalCnt")
	public ResponseEntity<Integer> dealListTotalCnt(@RequestParam String searchWord,
			@RequestParam String searchType, @RequestParam String userSeq) {

		int totalCnt = 0;
		if ("apt".equals(searchType)) {
			if ("".equals(searchWord)) {
				totalCnt = dealService.dealListTotalCnt();
				System.out.println("==========DealController==========");
				System.out.println("totalCnt : " + totalCnt);
				return new ResponseEntity<Integer>(totalCnt, HttpStatus.OK);
			} else {
				totalCnt = dealService.dealListSearchAptTotalCnt(searchWord);
				System.out.println("==========DealController==========");
				System.out.println("totalCnt : " + totalCnt);
				return new ResponseEntity<Integer>(totalCnt, HttpStatus.OK);
			}
		} else if ("dong".equals(searchType)) {
			totalCnt = dealService.dealListSearchDongTotalCnt(searchWord);
			System.out.println("==========DealController==========");
			System.out.println("totalCnt : " + totalCnt);
			return new ResponseEntity<Integer>(totalCnt, HttpStatus.OK);
		} else if ("bookmark".equals(searchType)) {
//			totalCnt = dealService.dealListBookmarkTotalCnt(userSeq);
		}

		return null;
	}
}

package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.SearchDto;
import com.ssafy.happyhouse.service.SearchService;


@RestController
public class SearchController {

	@Autowired
	SearchService searchService;

	@GetMapping("/search")
	public ResponseEntity<List<SearchDto>> sidoList() {
		System.out.println("sidoList called!!!");
		List<SearchDto> list = searchService.sidoList();
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<SearchDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<SearchDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/search/{sidoName}")
	public ResponseEntity<List<SearchDto>> gugunList(@PathVariable String sidoName) {
		System.out.println("gugunList called!!!");
		List<SearchDto> list = searchService.gugunList(sidoName);
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<SearchDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<SearchDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/search/{sidoName}/{gugunName}")
	public ResponseEntity<List<SearchDto>> dongList(@PathVariable("sidoName") String sidoName, @PathVariable("gugunName") String gugunName) {
		System.out.println("dongList called!!!");
		List<SearchDto> list = searchService.dongList(sidoName, gugunName);
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<SearchDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<SearchDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

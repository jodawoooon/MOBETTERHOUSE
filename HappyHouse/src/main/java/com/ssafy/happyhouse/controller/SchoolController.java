package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.SchoolDto;
import com.ssafy.happyhouse.dto.SchoolResultDto;
import com.ssafy.happyhouse.service.SchoolService;

@CrossOrigin(
		origins = "http://localhost:5500", 
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS}
)
@RestController
public class SchoolController {
	
	@Autowired
	SchoolService service;
	
	
	@GetMapping("/school/{dongName}")
	public ResponseEntity<SchoolResultDto> schoolList(@PathVariable String dongName, HttpSession session) {
		
		System.out.println(dongName);
		SchoolResultDto resultDto = new SchoolResultDto();
		
		List<SchoolDto> list = service.schoolList(dongName);
		int cnt = service.schoolListCnt(dongName);
		
		if(cnt!=0) {
			resultDto.setCnt(cnt);
			resultDto.setList(list);
			session.setAttribute("schoolResultDto", resultDto);
			return new ResponseEntity<SchoolResultDto>(resultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<SchoolResultDto>(resultDto, HttpStatus.NOT_FOUND);
		}

	}
	

}

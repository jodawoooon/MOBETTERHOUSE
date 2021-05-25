package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.InfoDto;
import com.ssafy.happyhouse.dto.InfoResultDto;

import com.ssafy.happyhouse.service.InfoService;

@CrossOrigin(
		origins = "http://localhost:5500", 
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS}
)
@RestController
public class InfoController {

	@Autowired
	InfoService service;
	
	@GetMapping("/info/{guName}")
	public ResponseEntity<InfoResultDto> infoList(@PathVariable String guName,  HttpSession session){
		System.out.println(guName);
		
		InfoResultDto resultDto = new InfoResultDto();
		
		InfoDto result = service.guInfo(guName);
		InfoDto avg = service.getAvg();
		if(result!=null) {
			resultDto.setInfo(result);
			resultDto.setAvg(avg);
			session.setAttribute("infoResultDto", resultDto);
			return new ResponseEntity<InfoResultDto>(resultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<InfoResultDto>(resultDto, HttpStatus.NOT_FOUND);
		}
	}
}

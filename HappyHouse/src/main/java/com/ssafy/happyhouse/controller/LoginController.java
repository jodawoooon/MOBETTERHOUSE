package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.service.LoginService;

//BoardFileUploadSpringBootMybatis 대비 @CrossOrign 추가 <-- vue cli mode 개발 대응
@CrossOrigin(
		origins = "http://localhost:5500", 
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS}
)
	@RestController
	public class LoginController {
	
		@Autowired
		LoginService service;
		
		@PostMapping(value="/login")
		public ResponseEntity<UserDto> login(@RequestBody UserDto dto, HttpSession session){
			System.out.println(service);
			UserDto userDto = service.login(dto);
			System.out.println(userDto);
			if( userDto != null ) {
				session.setAttribute("userDto", userDto);
				return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
			}
			return new ResponseEntity<UserDto>(userDto, HttpStatus.NOT_FOUND);
		}
	}



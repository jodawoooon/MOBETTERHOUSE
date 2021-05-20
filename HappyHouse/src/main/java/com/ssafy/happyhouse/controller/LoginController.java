package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.service.LoginService;


@ComponentScan(basePackages = { "com.ssafy.happyhouse.service" })
@RestController
public class LoginController {

	@Autowired
	LoginService service;

	@PostMapping(value = "/login")
	public ResponseEntity<UserDto> login(@RequestBody UserDto dto, HttpSession session) {

		UserDto userDto = service.login(dto);
		if (userDto != null) {
			session.setAttribute("userDto", userDto);
			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		
		} else {
			return new ResponseEntity<UserDto>(userDto, HttpStatus.NOT_FOUND);
		}
		
		

	}	
	
	@PostMapping(value= "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}


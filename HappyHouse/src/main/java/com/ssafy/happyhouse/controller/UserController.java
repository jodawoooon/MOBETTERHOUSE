package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.UserResultDto;
import com.ssafy.happyhouse.service.UserService;


@CrossOrigin(
		origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
)

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;
	

	@PostMapping(value="/user")
	public ResponseEntity<UserDto> userRegister(@RequestBody UserDto dto, HttpSession session){
		
		UserDto userDto = service.userRegister(dto);
		UserDto resultDto = service.userInfo(userDto.getUserEmail());
		if( resultDto != null ) {
			session.setAttribute("userDto", resultDto);
			return new ResponseEntity<UserDto>(resultDto, HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(resultDto, HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping(value = "/user/{userEmail}")
	public ResponseEntity<UserResultDto> userSecession(@PathVariable String userEmail, HttpSession session){
		
		UserResultDto userResultDto = service.userSecession(userEmail);
		
		if( userResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/user/{userEmail}")
	public ResponseEntity<UserDto> userEdit(@PathVariable String userEmail,@RequestBody UserDto userDto, HttpSession session){
		
		UserDto resultDto = service.userEdit(userDto);
		
		if( resultDto != null ) {
			session.setAttribute("userDto", resultDto);
			return new ResponseEntity<UserDto>(resultDto, HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(resultDto, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/user/{userEmail}")
	public ResponseEntity<UserDto> userInfo(@PathVariable String userEmail, HttpSession session) {
	
		UserDto userDto = service.userInfo(userEmail);
		
		if( userDto != null ) {
			session.setAttribute("userDto", userDto);
			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(userDto, HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping(value = "/user/find/{userEmail}")
	public UserDto userFindPass(@PathVariable String userEmail, HttpSession session) {
		System.out.println(userEmail);
		UserDto findDto = service.userFindPass(userEmail);
		
		if (findDto != null) {
			return findDto;
		} else {
			return null;
		}
	}
}

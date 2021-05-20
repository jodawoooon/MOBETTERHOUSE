package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.service.UserService;

@ComponentScan(basePackages = { "com.ssafy.happyhouse.service" })
@RestController
public class UserController {

	@Autowired
	UserService service;

	private static final int SUCCESS = 1;

	@PostMapping(value = "/user")
	public UserDto userRegister(UserDto userDto) {

		int ret = service.userRegister(userDto);

		if (ret == 1) {
			return userDto;
		} else {
			return null;
		}

	}
	
	@DeleteMapping(value = "/user")
	public UserDto userSecession(UserDto userDto) {
		System.out.println(userDto);
		int ret = service.userSecession(userDto);
		
		if (ret == 1) {
			return userDto;
		} else {
			return null;
		}
	}
	
	@PutMapping(value = "/user")
	public UserDto userEdit(UserDto userDto) {
		int ret = service.userEdit(userDto);
		System.out.println(userDto);
		System.out.println(ret);
		if (ret == 1) {
			return userDto;
		} else {
			return null;
		}
		
	}
	
	@GetMapping(value = "/user")
	public UserDto userInfo(HttpSession session, HttpServletResponse response) {
		
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		
		//System.out.println(res);
//		Gson gson = new Gson();
//		JsonObject jsonObject = new JsonObject();
//		jsonObject.addProperty("Email", userDto.getUserEmail());
//		jsonObject.addProperty("Name", userDto.getUserName());
//		String jsonStr = gson.toJson(jsonObject);
//		
		
		//System.out.println(jsonStr);
		return userDto;
		
	}
	
	@GetMapping(value = "/user/find")
	public UserDto userFindPass(UserDto userDto) {
		System.out.println(userDto.getUserEmail());
		UserDto findDto = service.userFindPass(userDto);
		System.out.println(findDto);
		if (findDto != null) {
			return findDto;
		} else {
			return null;
		}
	}
	
	
	
}

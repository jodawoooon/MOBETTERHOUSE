package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.CodeDto;
import com.ssafy.happyhouse.service.CodeService;

//BoardFileUploadSpringBootMybatis 대비 @CrossOrign 추가 <-- vue cli mode 개발 대응
@CrossOrigin(
		origins = "http://localhost:5500", 
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS}
)
	@RestController
	public class CodeController {
	
		@Autowired
		CodeService service;
		
		@GetMapping(value="/codes")
		public ResponseEntity<List<CodeDto>> codeList(String groupCode){
			
			List<CodeDto> list = service.codeList(groupCode);
			if( list != null ) {
				return new ResponseEntity<List<CodeDto>>(list, HttpStatus.OK);
			}

			return new ResponseEntity<List<CodeDto>>(list, HttpStatus.NOT_FOUND);
		}
	}



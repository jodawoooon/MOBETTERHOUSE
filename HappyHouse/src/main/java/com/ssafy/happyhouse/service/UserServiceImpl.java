package com.ssafy.happyhouse.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.happyhouse.dao.UserDao;
import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.UserResultDto;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	UserDao userDao;
	String uploadFolder = "upload";

	/* for production code */
//	String uploadPath = getServletContext().getRealPath("/");
	// F:\SSAFY\ssafy5\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\BoardWebFileUpload\
	
	/* for eclipse development code */
//	String uploadPath = "C:\\Users\\uj020\\git\\13pairvue\\HappyHouse" 
//			+ File.separator + "src" 
//			+ File.separator + "main"
//			+ File.separator + "resources"
//			+ File.separator + "static";
//	String uploadPath = 
//			File.separator + "Users" + 
//			File.separator + "dongwoosohn" + 
//			File.separator + "SSAFY" + 
//			File.separator + "Pair" + 
//			File.separator + "13pairvue" +
//			File.separator + "HappyHouse" +
//			File.separator + "src" +
//			File.separator + "main" +
//			File.separator + "resources" +
//			File.separator + "static";
	
	String uploadPath = "/Users/dongwoosohn/SSAFY/Pair/13pairvue/HappyHouse/src/main/resources/static";
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;
	
	@Override
	public UserDto userRegister(UserDto userDto) {
		
		if( userDto != null && userDao.userRegister(userDto) == 1 ) {
			return userDto;
		}else {
			return null;
		}
		
	}
	
	@Override
	public UserDto userEdit(UserDto userDto) {
		
		if( userDto != null && userDao.userEdit(userDto) == 1 ) {
			return userDto;
		}else {
			return null;
		}
		
	}
	
	@Override
	public UserDto userFindPass(String userEmail) {
		// TODO Auto-generated method stub
		return userDao.userFindPass(userEmail);
	}
	
	@Override
	public UserResultDto userSecession(String userEmail) {
		UserResultDto userResultDto = new UserResultDto();
		if( userDao.userSecession(userEmail) == 1 ) {
			userResultDto.setResult(SUCCESS);
		}else {
			userResultDto.setResult(FAIL);
		}
		
		return userResultDto;
	}
	
	@Override
	public UserDto userInfo(String userEmail) {
		// TODO Auto-generated method stub
		return userDao.userInfo(userEmail);
	}

	@Override
	public UserDto insertUserProfileImage(String userEmail, MultipartHttpServletRequest request) {
		
		UserDto resultDto = new UserDto();
		
		try {
			
			MultipartFile file = request.getFile("file");
			//System.out.println(file);
			File uploadDir = new File(uploadPath + File.separator + uploadFolder);
			System.out.println(uploadDir);
			if (!uploadDir.exists()) uploadDir.mkdir();
			
			String fileName = file.getOriginalFilename();
			
			UUID uuid = UUID.randomUUID();
			
			//file extension
			String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName()
		
			String savingFileName = uuid + "." + extension;
		
			File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
			
			//System.out.println(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
			file.transferTo(destFile);
			
			String boardFileUrl = "/"+uploadFolder + "/" + savingFileName;
			
			System.out.println(boardFileUrl);
			
			resultDto.setUserEmail(userEmail);
			resultDto.setUserProfileImageUrl(boardFileUrl);
			userDao.insertUserProfileImage(resultDto);
			
			
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
		return resultDto;
	}
	
}

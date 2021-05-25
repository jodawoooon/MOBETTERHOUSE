package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.BookmarkAreaDto;
import com.ssafy.happyhouse.dto.BookmarkDto;
import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseParamDto;
import com.ssafy.happyhouse.dto.HouseResultDto;
import com.ssafy.happyhouse.service.HouseService;

//BoardFileUploadSpringBootMybatis 대비 @CrossOrign 추가 <-- vue cli mode 개발 대응
@CrossOrigin(origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
				RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS })
@RestController
public class HouseContoller {

	@Autowired
	HouseService houseService;

	@GetMapping("/house")
	public HouseResultDto houseList(int limit, int offset, String searchWord, String searchType, int userSeq) {
		System.out.println("/house1!!!!!!");
		HouseParamDto param = new HouseParamDto();
		param.setLimit(limit);
		param.setOffset(offset);
		param.setUserSeq(userSeq);

		HouseResultDto result = new HouseResultDto();
		if (searchType.equals("init")) {
			System.out.println("/house2!!!!!!");
			List<HouseDto> list = houseService.houseList(param);
			for (HouseDto dto : list)
				System.out.println(dto);
			int count = houseService.houseListTotalCount();
			if (list != null) {
				result.setResult(1);
				result.setList(list);
				result.setCount(count);

				for (HouseDto dto : list) {
					System.out.println(dto);
				}
				System.out.println("count : " + count);
			} else {
				result.setResult(0);
			}
		} else if (searchType.equals("dong")) {
			System.out.println("/house searchDong!!!!");
			param.setSearchWord(searchWord);
			List<HouseDto> list = houseService.houseSearchDong(param);
			for (HouseDto dto : list)
				System.out.println(dto);
			int count = houseService.houseSearchDongTotalCount(searchWord);
			if (list != null) {
				result.setResult(1);
				result.setList(list);
				result.setCount(count);

				for (HouseDto dto : list) {
					System.out.println(dto);
				}
				System.out.println("count : " + count);
			} else {
				result.setResult(0);
			}
		} else if (searchType.equals("apt")) {
			System.out.println("/house searchApt!!!!");
			param.setSearchWord(searchWord);
			List<HouseDto> list = houseService.houseSearchApt(param);
			for (HouseDto dto : list)
				System.out.println(dto);
			int count = houseService.houseSearchAptTotalCount(searchWord);
			if (list != null) {
				result.setResult(1);
				result.setList(list);
				result.setCount(count);

				for (HouseDto dto : list) {
					System.out.println(dto);
				}
				System.out.println("count : " + count);
			} else {
				result.setResult(0);
			}
		} else if (searchType.equals("bookmarkHouse")) {
			System.out.println("/house bookmarkHouse!!!");
			List<HouseDto> list = houseService.bookmarkHouse(userSeq);
			for (HouseDto dto : list)
				System.out.println(dto);
			int count = houseService.bookmarkHouseTotalCount(userSeq);
			if (list != null) {
				result.setResult(1);
				result.setList(list);
				result.setCount(count);

				for (HouseDto dto : list) {
					System.out.println(dto);
				}
				System.out.println("count : " + count);
			} else {
				result.setResult(0);
			}
		} else if (searchType.equals("bookmarkArea")) {
			System.out.println("/house bookmarkArea");
			List<HouseDto> list = houseService.bookmarkArea(userSeq);
			for (HouseDto dto : list)
				System.out.println(dto);
			int count = houseService.bookmarkAreaTotalCount(userSeq);
			if (list != null) {
				result.setResult(1);
				result.setList(list);
				result.setCount(count);

				for (HouseDto dto : list) {
					System.out.println(dto);
				}
				System.out.println("count : " + count);
			} else {
				result.setResult(0);
			}
		}
		return result;
	}

	@GetMapping("/sido")
	public ResponseEntity<List<Map<String, String>>> sidoList() {
		System.out.println("/sidoList!!!");
		List<Map<String, String>> ret = houseService.sidoList();
		if (ret.isEmpty() || ret == null) {
			return new ResponseEntity<List<Map<String, String>>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			for (Map<String, String> sido : ret) {
				System.out.println(sido);
			}
			return new ResponseEntity<List<Map<String, String>>>(ret, HttpStatus.OK);
		}
	}

	@GetMapping("/gugun")
	public ResponseEntity<List<Map<String, String>>> gugunList(String sidoCode) {
		System.out.println("/gugunList!!!!");
		System.out.println(sidoCode);
		List<Map<String, String>> ret = houseService.gugunList(sidoCode);
		if (ret.isEmpty() || ret == null) {
			return new ResponseEntity<List<Map<String, String>>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			for (Map<String, String> gugun : ret) {
				System.out.println(gugun);
			}
			return new ResponseEntity<List<Map<String, String>>>(ret, HttpStatus.OK);
		}
	}

	@GetMapping("/dong")
	public ResponseEntity<List<Map<String, String>>> dongList(String sidoCode, String gugunCode) {
		System.out.println("/dongList!!!!");
		System.out.println(sidoCode + " / " + gugunCode);

		Map<String, String> map = new HashMap<String, String>();
		map.put("sidoCode", sidoCode);
		map.put("gugunCode", gugunCode);

		List<Map<String, String>> ret = houseService.dongList(map);
		if (ret.isEmpty() || ret == null) {
			return new ResponseEntity<List<Map<String, String>>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			for (Map<String, String> dong : ret) {
				System.out.println(dong);
			}
			return new ResponseEntity<List<Map<String, String>>>(ret, HttpStatus.OK);
		}
	}

	@PostMapping("/bookmark")
	public ResponseEntity<Integer> insertBookmark(@RequestBody BookmarkDto bookmarkDto) {
		System.out.println("CREATE bookmark!!!!");
		System.out.println("userSeq : " + bookmarkDto.getUserSeq());
		System.out.println("dealNo : " + bookmarkDto.getDealNo());

		int ret = houseService.insertBookmark(bookmarkDto);
		if (ret != 1) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Integer>(ret, HttpStatus.OK);
		}
	}

	@DeleteMapping("/bookmark")
	public ResponseEntity<Integer> deleteBookmark(int userSeq, int dealNo) {
		System.out.println("DELETE bookmark!!!!");
		BookmarkDto bookmarkDto = new BookmarkDto();
		bookmarkDto.setUserSeq(userSeq);
		bookmarkDto.setDealNo(dealNo);
		System.out.println("userSeq : " + bookmarkDto.getUserSeq());
		System.out.println("dealNo : " + bookmarkDto.getDealNo());

		int ret = houseService.deleteBookmark(bookmarkDto);
		if (ret != 1) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Integer>(ret, HttpStatus.OK);
		}
	}

	@PostMapping("/bookmarkArea")
	public ResponseEntity<Integer> insertBookmarkArea(@RequestBody BookmarkAreaDto bookmarkAreaDto) {
		System.out.println("CREATE bookmarkArea!!!!");
		System.out.println("userSeq : " + bookmarkAreaDto.getUserSeq());
		System.out.println("dealNo : " + bookmarkAreaDto.getDongCode());

		int ret = houseService.insertBookmarkArea(bookmarkAreaDto);
		if (ret != 1) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Integer>(ret, HttpStatus.OK);
		}
	}

	@DeleteMapping("/bookmarkArea")
	public ResponseEntity<Integer> deleteBookmarkArea(int userSeq, int dongCode) {
		System.out.println("DELETE bookmark!!!!");
		BookmarkAreaDto bookmarkAreaDto = new BookmarkAreaDto();
		bookmarkAreaDto.setUserSeq(userSeq);
		bookmarkAreaDto.setDongCode(dongCode);
		System.out.println("userSeq : " + bookmarkAreaDto.getUserSeq());
		System.out.println("dealNo : " + bookmarkAreaDto.getDongCode());

		int ret = houseService.deleteBookmarkArea(bookmarkAreaDto);
		if (ret != 1) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Integer>(ret, HttpStatus.OK);
		}
	}

	@GetMapping("/bookmarkArea")
	public ResponseEntity<Boolean> getBookmarkArea(int userSeq, int dongCode) {
		System.out.println("SELECT bookmark!!!!");
		BookmarkAreaDto bookmarkAreaDto = new BookmarkAreaDto();
		bookmarkAreaDto.setUserSeq(userSeq);
		bookmarkAreaDto.setDongCode(dongCode);
		System.out.println("userSeq : " + bookmarkAreaDto.getUserSeq());
		System.out.println("dealNo : " + bookmarkAreaDto.getDongCode());

		boolean ret = houseService.getBookmarkArea(bookmarkAreaDto);
		return new ResponseEntity<Boolean>(ret, HttpStatus.OK);
	}
}

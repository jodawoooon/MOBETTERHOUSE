package com.ssafy.happyhouse.dto;

import java.util.List;

public class HouseResultDto {
	private int result;
	private HouseDto dto;
	private List<HouseDto> list;
	private int count;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public HouseDto getDto() {
		return dto;
	}

	public void setDto(HouseDto dto) {
		this.dto = dto;
	}

	public List<HouseDto> getList() {
		return list;
	}

	public void setList(List<HouseDto> list) {
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "HouseResultDto [result=" + result + ", dto=" + dto + ", list=" + list + ", count=" + count + "]";
	}
}

package com.ssafy.happyhouse.dto;

public class InfoDto {
	private String guName;
	private int popNum;
	private int popDensity;
	private int storeNum;
	private int nurseryNum;
	private int careNum;
	private int parkNum;
	private int libNum;
	private int parkingNum;
	private int hospitalNum;

	public String getGuName() {
		return guName;
	}

	public void setGuName(String guName) {
		this.guName = guName;
	}

	public int getPopNum() {
		return popNum;
	}

	public void setPopNum(int popNum) {
		this.popNum = popNum;
	}

	public int getPopDensity() {
		return popDensity;
	}

	public void setPopDensity(int popDensity) {
		this.popDensity = popDensity;
	}

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public int getNurseryNum() {
		return nurseryNum;
	}

	public void setNurseryNum(int nurseryNum) {
		this.nurseryNum = nurseryNum;
	}

	public int getCareNum() {
		return careNum;
	}

	public void setCareNum(int careNum) {
		this.careNum = careNum;
	}

	public int getParkNum() {
		return parkNum;
	}

	public void setParkNum(int parkNum) {
		this.parkNum = parkNum;
	}

	public int getLibNum() {
		return libNum;
	}

	public void setLibNum(int libNum) {
		this.libNum = libNum;
	}

	public int getParkingNum() {
		return parkingNum;
	}

	public void setParkingNum(int parkingNum) {
		this.parkingNum = parkingNum;
	}

	public int getHospitalNum() {
		return hospitalNum;
	}

	public void setHospitalNum(int hospitalNum) {
		this.hospitalNum = hospitalNum;
	}

	@Override
	public String toString() {
		return "InfoDto [guName=" + guName + ", popNum=" + popNum + ", popDensity=" + popDensity + ", storeNum="
				+ storeNum + ", nurseryNum=" + nurseryNum + ", careNum=" + careNum + ", parkNum=" + parkNum
				+ ", libNum=" + libNum + ", parkingNum=" + parkingNum + ", hospitalNum=" + hospitalNum + "]";
	}

}

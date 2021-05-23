package com.ssafy.happyhouse.dto;

public class SchoolDto {
	private String schoolType;
	private String schoolName;
	private String schoolZipCode;
	private String schoolAddress1;
	private String schoolAddress2;
	private String schoolPhone;
	private String schoolEstDate;
	public String getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolZipCode() {
		return schoolZipCode;
	}
	public void setSchoolZipCode(String schoolZipCode) {
		this.schoolZipCode = schoolZipCode;
	}
	public String getSchoolAddress1() {
		return schoolAddress1;
	}
	public void setSchoolAddress1(String schoolAddress1) {
		this.schoolAddress1 = schoolAddress1;
	}
	public String getSchoolAddress2() {
		return schoolAddress2;
	}
	public void setSchoolAddress2(String schoolAddress2) {
		this.schoolAddress2 = schoolAddress2;
	}
	public String getSchoolPhone() {
		return schoolPhone;
	}
	public void setSchoolPhone(String schoolPhone) {
		this.schoolPhone = schoolPhone;
	}
	public String getSchoolEstDate() {
		return schoolEstDate;
	}
	public void setSchoolEstDate(String schoolEstDate) {
		this.schoolEstDate = schoolEstDate;
	}
	@Override
	public String toString() {
		return "SchoolDto [schoolType=" + schoolType + ", schoolName=" + schoolName + ", schoolZipCode=" + schoolZipCode
				+ ", schoolAddress1=" + schoolAddress1 + ", schoolAddress2=" + schoolAddress2 + ", schoolPhone="
				+ schoolPhone + ", schoolEstDate=" + schoolEstDate + "]";
	}
	
	
	
}

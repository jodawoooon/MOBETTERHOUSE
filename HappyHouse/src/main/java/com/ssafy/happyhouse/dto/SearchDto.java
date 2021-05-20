package com.ssafy.happyhouse.dto;

public class SearchDto {
	private String sidoCode;
	private String sidoName;
	private String gugunCode;
	private String gugunName;
	private String dongCode;
	private String dongName;

	public String getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(String siCode) {
		this.sidoCode = siCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String siName) {
		this.sidoName = siName;
	}

	public String getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(String guGunCode) {
		this.gugunCode = guGunCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String guGunName) {
		this.gugunName = guGunName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	@Override
	public String toString() {
		return "SearchDto [siCode=" + sidoCode + ", siName=" + sidoName + ", gugunCode=" + gugunCode + ", gugunName="
				+ gugunName + ", dongCode=" + dongCode + ", dongName=" + dongName + "]";
	}
}

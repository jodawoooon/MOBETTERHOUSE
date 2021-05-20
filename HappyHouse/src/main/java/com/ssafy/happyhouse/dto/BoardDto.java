package com.ssafy.happyhouse.dto;

import java.time.LocalDateTime;

public class BoardDto {
	private int boardId;
	private int userSeq;
	private String userName;
	private String userProfileImageUrl;
	private String title;
	private String content;
	// private LocalDate regDt;
	private LocalDateTime regDt;
	private int readCount;

	// private List<BoardFileDto> fileList;

	public BoardDto() {
	};

	public BoardDto(int userSeq, String title, String content) {
		this.userSeq = userSeq;
		this.title = title;
		this.content = content;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserProfileImageUrl() {
		return userProfileImageUrl;
	}

	public void setUserProfileImageUrl(String userProfileImageUrl) {
		if (userProfileImageUrl == null || "null".equals(userProfileImageUrl) || "".equals(userProfileImageUrl)) {
			this.userProfileImageUrl = "/img/noProfile.png";
		} else {
			this.userProfileImageUrl = userProfileImageUrl;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[BoardDto - boardId : ");
		sb.append(this.boardId);
		sb.append(", userSeq : ");
		sb.append(this.userSeq);
		sb.append(", userName : ");
		sb.append(this.userName);
		sb.append(", userProfileImageUrl : ");
		sb.append(this.userProfileImageUrl);
		sb.append(", title : ");
		sb.append(this.title);
		sb.append(", content : ");
		sb.append(this.content);
		sb.append(", regDt : ");
		sb.append(this.regDt);
		sb.append(", readCount : ");
		sb.append(this.readCount);
		sb.append("]");

		return sb.toString();
	}
}

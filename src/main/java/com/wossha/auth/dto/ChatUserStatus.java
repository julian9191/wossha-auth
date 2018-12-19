package com.wossha.auth.dto;

public class ChatUserStatus {
	
	private String id;
	private String displayName;
	private String avatar;
	private Integer status;
	
	public ChatUserStatus(String id, String displayName, String avatar, Integer status) {
		this.id = id;
		this.displayName = displayName;
		this.avatar = avatar;
		this.status = status;
	}

	public ChatUserStatus() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}

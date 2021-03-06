package com.wossha.auth.dto;

public class UserMinimumDTO {
	private String username;
	private String name;
	private String profilePicture;
	
	public UserMinimumDTO(String username, String name, String profilePicture) {
		this.username = username;
		this.name = name;
		this.profilePicture = profilePicture;
	}

	public UserMinimumDTO() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	
	
}

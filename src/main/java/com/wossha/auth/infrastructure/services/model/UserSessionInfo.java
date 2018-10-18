package com.wossha.auth.infrastructure.services.model;

public class UserSessionInfo {
	
	public String firstName;
	public String lastName;
	public String picture;
	
	public UserSessionInfo(String firstName, String lastName, String picture) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.picture = picture;
	}

	public UserSessionInfo() {}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}
}

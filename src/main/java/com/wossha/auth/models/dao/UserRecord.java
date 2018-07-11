package com.wossha.auth.models.dao;

import java.util.List;
import java.sql.Timestamp;

public class UserRecord{

	private String username;
	private String password;
	private Boolean enabled;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private Timestamp birthday;
    private List<String> roles;
    
    
	public UserRecord(String username, String password, String firstName, String lastName, String gender, String email, Boolean enabled, Timestamp birthday, List<String> roles) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.enabled = enabled;
		this.birthday = birthday;
		this.roles = roles;
	}
	
	public UserRecord() {}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	
	
	
}
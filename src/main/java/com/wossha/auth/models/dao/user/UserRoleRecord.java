package com.wossha.auth.models.dao.user;

public class UserRoleRecord{
	
	private long id;
	private String username;
	private String roleName;
	
	public UserRoleRecord(long id, String username, String roleName) {
		super();
		this.id = id;
		this.username = username;
		this.roleName = roleName;
	}
	
	public UserRoleRecord(String username, String roleName) {
		super();
		this.username = username;
		this.roleName = roleName;
	}

	public UserRoleRecord() {
		super();
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
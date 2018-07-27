package com.wossha.auth.infrastructure.enums;

public enum RolesEnum {
	USER("USER"), 
	ADMIN("ADMIN");

	private String description;

	RolesEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
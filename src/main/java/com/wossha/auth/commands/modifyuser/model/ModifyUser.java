package com.wossha.auth.commands.modifyuser.model;

import com.wossha.auth.infrastructure.dao.user.UserRecord;
import com.wossha.msbase.controllers.commands.CommandModel;

public class ModifyUser extends CommandModel{
	private String commandName;
    private String username;
    private UserRecord user;
    
	
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserRecord getUser() {
		return user;
	}
	public void setUser(UserRecord user) {
		this.user = user;
	}
	
	
}

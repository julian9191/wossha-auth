package com.wossha.auth.commands.modifyuser.model;

import com.wossha.msbase.commands.CommandModel;

public class ModifyUser extends CommandModel{
	private String commandName;
    private String username;
    private UserDTO user;
    
	
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
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
}

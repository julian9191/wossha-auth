package com.wossha.auth.commands.modifyuser;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.auth.commands.modifyuser.model.ModifyUser;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.commands.ICommandSerializer;

@Component
public class ModifyUserSerializer implements ICommandSerializer {
	
	private ObjectMapper m = new ObjectMapper();
	
	@Autowired
	private ModifyUserCommand command;
	
	@Override
	public ICommand<ModifyUser> deserialize(String json) throws IOException {
		ModifyUser dto = m.readValue(json, ModifyUser.class);
        command.setData(dto);
        return command;
	}

}

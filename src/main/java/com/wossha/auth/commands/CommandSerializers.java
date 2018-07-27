package com.wossha.auth.commands;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wossha.auth.commands.modifyuser.ModifyUserSerializer;
import com.wossha.msbase.controllers.commands.ICommandSerializer;

@Service
public class CommandSerializers {

    private final Map<String, ICommandSerializer> processors = new HashMap<>();
    
    //serializers
    @Autowired
    private ModifyUserSerializer modifyUserSerializer;

	public void initMapper() {
        processors.put("ModifyUser", modifyUserSerializer);
    }

    public ICommandSerializer get(String commandName) {
        return processors.get(commandName);
    }
    
    public void setModifyUserSerializer(ModifyUserSerializer modifyUserSerializer) {
		this.modifyUserSerializer = modifyUserSerializer;
	}
}

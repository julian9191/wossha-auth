package com.wossha.auth.commands.modifyuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wossha.auth.commands.modifyuser.model.ModifyUser;
import com.wossha.auth.infrastructure.repositories.UserRepository;
import com.wossha.msbase.commands.CommandResult;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;

@Component
public class ModifyUserCommand implements ICommand<ModifyUser>{
	
	private ModifyUser data;
	private String username;
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public String commandName() {
		return "ModifyUser";
	}
	
	@Override
	public ModifyUser data() {
		return this.data;
	}

	@Override
	public void setData(ModifyUser data) {
		this.data = data;
		
	}

	@Override
	public CommandResult execute() throws BusinessException, TechnicalException {
		
		CommandResult result = new CommandResult();
		try {
			repo.update(data.getUser());
			result.setMessage("La modificación de datos se ha realizado correctamente");
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			throw new TechnicalException("Ha ocurrido un error al intentar modificar el usuario");
		}
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

}

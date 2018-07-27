package com.wossha.auth.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wossha.auth.commands.CommandSerializers;
import com.wossha.auth.commands.modifyuser.ModifyUserCommand;
import com.wossha.auth.commands.modifyuser.ModifyUserSerializer;
import com.wossha.auth.infrastructure.repositories.CountryRepository;
import com.wossha.auth.infrastructure.repositories.UserRepository;

@Configuration
public class BeansConfig {
	
	@Bean
	public UserRepository userRpository() {
			return new UserRepository();
	}

	@Bean
	public CountryRepository countryRepository() {
		return new CountryRepository();
	}

	@Bean
	public ModifyUserCommand modifyUserCommand() {
		return new ModifyUserCommand();
	}
	
	@Bean
	public ModifyUserSerializer modifyUserSerializer() {
		return new ModifyUserSerializer();
	}
	
	@Bean
	public CommandSerializers commandSerializers() {
		CommandSerializers cs = new CommandSerializers();
		cs.setModifyUserSerializer(modifyUserSerializer());
		cs.initMapper();
		return cs;
	}
	
}

package com.wossha.auth.configure;

import java.util.TimeZone;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		TimeZone tz = TimeZone.getDefault();
		objectMapper.setTimeZone(tz);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}
	
	@Bean
	public CommandSerializers commandSerializers() {
		CommandSerializers cs = new CommandSerializers();
		cs.setModifyUserSerializer(modifyUserSerializer());
		cs.initMapper();
		return cs;
	}
	
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer init() {
	    return new Jackson2ObjectMapperBuilderCustomizer() {

	    	@Override
	        public void customize(Jackson2ObjectMapperBuilder builder) {
	            builder.timeZone(TimeZone.getDefault());
	        }
	    };
	}
	
}

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
import com.wossha.auth.infrastructure.jms.EventSerializers;
import com.wossha.auth.infrastructure.jms.userConnectionEvent.UserConnectionEventSerializer;
import com.wossha.auth.infrastructure.repositories.CountryRepository;
import com.wossha.auth.infrastructure.repositories.UserRepository;
import com.wossha.json.events.events.pictures.SavePictureEvent.SavePictureEvent;
import com.wossha.json.events.events.social.userConnectedEvent.UserConnectionEvent;

@Configuration
public class BeansConfig {
	
	//--REPOSITORIES-------------------------------------------
	@Bean
	public UserRepository userRpository() {
			return new UserRepository();
	}

	@Bean
	public CountryRepository countryRepository() {
		return new CountryRepository();
	}

	
	//-COMMANDS-----------------------------------------------
	
	@Bean
	public ModifyUserCommand modifyUserCommand() {
		return new ModifyUserCommand();
	}
	
	//-COMMAND SERIALIZERS----------------------------------------------
	@Bean
	public ModifyUserSerializer modifyUserSerializer() {
		return new ModifyUserSerializer();
	}
	
	//EVENTS----------------------------------------------------------------
	@Bean
	public UserConnectionEvent userConnectionEvent() {
		return new UserConnectionEvent();
	}
	
	//EVENTS LISTENERS----------------------------------------------------------
	@Bean
	public UserConnectionEventSerializer userConnectionEventSerializer() {
		return new UserConnectionEventSerializer();
	}
	
	
	//-------------------------------------------------------------------------
	
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
	public EventSerializers eventSerializers() {
		EventSerializers es = new EventSerializers();
		es.setUserConnectedEventSerializer(userConnectionEventSerializer());;
		es.initMapper();
		return es;
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

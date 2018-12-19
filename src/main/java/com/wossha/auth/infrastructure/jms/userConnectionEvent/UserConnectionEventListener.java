package com.wossha.auth.infrastructure.jms.userConnectionEvent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wossha.auth.infrastructure.repositories.UserRepository;
import com.wossha.json.events.events.api.Event;
import com.wossha.json.events.events.api.EventProcessor;
import com.wossha.json.events.events.social.userConnectedEvent.UserConnectionEvent;
import com.wossha.json.events.exceptions.RecoverableException;

@Component
public class UserConnectionEventListener implements EventProcessor<UserConnectionEvent>  {
    
	private UserConnectionEvent data;

	@Autowired
	private UserRepository repo;
    
    @Override
    public String name() {
        return "AsesoriaRecibidaBPM";
    }
    @Override
    public UserConnectionEvent data() {
        return data;
    }
    @Override
    public void setData(UserConnectionEvent data) {
        this.data = data;
    }
    @Override
    public List<Event> execute() throws RecoverableException{
        List<Event> events = new ArrayList<>();
        
		repo.updateOnlineStatus(data.getMessage().getUsername(), data.getMessage().getStatus());
		
        return events;
    }
}

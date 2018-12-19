package com.wossha.auth.infrastructure.jms.userConnectionEvent;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.json.events.events.api.EventProcessor;
import com.wossha.json.events.events.api.EventSerializer;
import com.wossha.json.events.events.pictures.SavePictureEvent.SavePictureEvent;
import com.wossha.json.events.events.social.userConnectedEvent.UserConnectionEvent;

@Component
public class UserConnectionEventSerializer implements EventSerializer {
    private final ObjectMapper m = new ObjectMapper();
    
    @Autowired
	private UserConnectionEventListener eventListener;

    @SuppressWarnings("rawtypes")
	@Override
    public EventProcessor deserialize(String json) throws IOException {
    	UserConnectionEvent event = m.readValue(json, UserConnectionEvent.class);
    	eventListener.setData(event);
        return eventListener;
    }
	
}

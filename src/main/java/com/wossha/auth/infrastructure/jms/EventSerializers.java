package com.wossha.auth.infrastructure.jms;

import java.util.HashMap;
import org.springframework.stereotype.Component;

import com.wossha.auth.infrastructure.jms.userConnectionEvent.UserConnectionEventSerializer;
import com.wossha.json.events.events.api.EventSerializer;

@Component
public class EventSerializers {

    private final HashMap<String, EventSerializer> listeners = new HashMap<>();
    
    private UserConnectionEventSerializer userConnectionEventSerializer;

    public void initMapper() {
        listeners.put("USER-CONNECTION", userConnectionEventSerializer);
    }

    public EventSerializer get(String eventName) {
        return listeners.get(eventName);
    }

	public void setUserConnectedEventSerializer(UserConnectionEventSerializer userConnectionEventSerializer) {
		this.userConnectionEventSerializer = userConnectionEventSerializer;
	}

}
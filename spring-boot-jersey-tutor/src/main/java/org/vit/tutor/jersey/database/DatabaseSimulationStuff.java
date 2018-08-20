package org.vit.tutor.jersey.database;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.vit.tutor.jersey.model.Message;

@Component
public class DatabaseSimulationStuff {
	
	Map<Long, Message> messages = new HashMap<>();

	
	
	@PostConstruct	
	public void init() {
		messages.put(1L, Message.builder()
				.id(1L)
				.messageText("test message")
				.createdDate(new Date())
		.build());
	}
}

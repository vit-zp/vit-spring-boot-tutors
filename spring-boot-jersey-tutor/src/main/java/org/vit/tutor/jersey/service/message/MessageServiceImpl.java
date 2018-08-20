package org.vit.tutor.jersey.service.message;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.vit.tutor.jersey.database.DatabaseSimulationStuff;
import org.vit.tutor.jersey.model.Message;

public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private DatabaseSimulationStuff databaseService;

	@Override
	public List<Message> getAllMessages() {
		return databaseService.getAllMessagesAsList();
	}

	@Override
	public Message getMessage(Long messageId) {
		return databaseService.getAllMessages()
				.get(messageId);
	}

	@Override
	public Message addMessage(Message message) {
		
		message.setId(databaseService.getAllMessages().keySet().stream()
				.reduce((k1, k2) -> {return k1>=k2 ? k1:k2;}).get()+1);
		return databaseService.getAllMessages().put(message.getId(), message);
	}

	@Override
	public Message updateMessage(Message message) {
	
		return databaseService.getAllMessages().put(message.getId(), message);
	}

	@Override
	public Message removeMessage(Message message) {
		
		return databaseService.getAllMessages().remove(message.getId());
	}

}

package org.vit.tutor.jersey.service.message;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vit.tutor.jersey.database.DatabaseSimulationStuff;
import org.vit.tutor.jersey.model.Message;
import org.vit.tutor.jersey.resource.comment.CommentResource;

@Component
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
		
		message.setId(1L + databaseService.getAllMessages().size());
		message.setCreatedDate(new Date());
		return databaseService.getAllMessages().put(message.getId(), message);
	}

	@Override
	public Message updateMessage(Message message) {
	
		return databaseService.getAllMessages().put(message.getId(), message);
	}

	@Override
	public Message removeMessage(Long messageId) {
		
		return databaseService.getAllMessages().remove(messageId);
	}
}

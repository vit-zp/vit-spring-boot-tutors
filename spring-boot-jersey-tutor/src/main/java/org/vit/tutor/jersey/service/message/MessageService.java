package org.vit.tutor.jersey.service.message;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vit.tutor.jersey.model.Message;

@Service
public interface MessageService {
	
		List<Message> getAllMessages();
		
		Message getMessage(Long messageId);
		
		Message addMessage(Message message);
		
		Message updateMessage(Message message);
		
		Message removeMessage(Message message);

}

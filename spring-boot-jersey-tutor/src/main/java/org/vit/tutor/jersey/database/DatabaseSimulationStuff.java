package org.vit.tutor.jersey.database;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.vit.tutor.jersey.model.Comment;
import org.vit.tutor.jersey.model.Message;

@Component
public class DatabaseSimulationStuff {
	
	Map<Long, Message> messages = new HashMap<>();
		
	@PostConstruct	
	public void init() {
		
		Map<Long, Comment> comments = new HashMap<>();
		comments.put(1L, Comment.builder()
				.commentId(1L)
				.commentText("Comment 1 text")
				.createdDate(new Date())
				.build());
		messages.put(1L, Message.builder()
				.id(1L)
				.messageText("test message")
				.createdDate(new Date())
				.comments(comments)
				.build());
	}



	public List<Message> getAllMessagesAsList() {
		return messages.values().stream().collect(Collectors.toList());
	}
	
	public Map<Long, Message> getAllMessages(){
		return messages;
	}
}

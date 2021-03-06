package org.vit.tutor.jersey.model;

import java.util.Date;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Message {
	
	private Long id;
	
	private String messageText;
	
	private Date createdDate;
	
	private Map<Long, Comment> comments;

}

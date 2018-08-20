package org.vit.tutor.jersey.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Message {
	
	private Long id;
	
	private String messageText;
	
	private Date createdDate;
	
	

}

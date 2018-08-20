package org.vit.tutor.jersey.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Comment {

	private Long commentId;
	
	private String commentText;
	
	private Date createdDate;
}

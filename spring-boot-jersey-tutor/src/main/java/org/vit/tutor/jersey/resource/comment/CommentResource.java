package org.vit.tutor.jersey.resource.comment;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vit.tutor.jersey.model.Comment;
import org.vit.tutor.jersey.service.comment.CommentService;

@Component
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	@Autowired
	private CommentService commentServcie;

	@GET
	public List<Comment> getAllComments(@PathParam("messageId") Long messageId){
		return commentServcie.getAllComments(messageId);
	}

}

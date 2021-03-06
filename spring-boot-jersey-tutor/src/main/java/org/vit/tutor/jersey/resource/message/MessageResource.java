package org.vit.tutor.jersey.resource.message;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vit.tutor.jersey.dto.assembler.MessageAssembler;
import org.vit.tutor.jersey.model.Message;
import org.vit.tutor.jersey.resource.comment.CommentResource;
import org.vit.tutor.jersey.service.message.MessageService;

@Component
@Path("/messages")
public class MessageResource {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private CommentResource commentResource;

	@Autowired
	private MessageAssembler messageAssembler;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessages(){
		return Response.ok(messageAssembler.toResources(messageService.getAllMessages()))
				.build();
		}
	

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@PathParam("messageId") Long messageId){
		return Response.ok(messageAssembler.toResource(messageService.getMessage(messageId)))
				.build();
		}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return messageService.addMessage(message);
		}
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") Long messageId, Message message){
		message.setId(messageId);
		return messageService.updateMessage(message);
		}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") Long messageId){
		return messageService.removeMessage(messageId);
		}

	@Path("/{messageId}/comments")
	public CommentResource getAllComments() {
		return commentResource;
	}
	
}

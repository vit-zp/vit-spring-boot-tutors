package org.vit.tutor.jersey.resource.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vit.tutor.jersey.dto.assembler.CommentAssembler;
import org.vit.tutor.jersey.model.Comment;
import org.vit.tutor.jersey.service.comment.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Date;

@Component
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	@Autowired
	private CommentService commentServcie;
	
	@Autowired
	private CommentAssembler commentAssembler;

	@GET
	public Response getAllComments(@PathParam("messageId") Long messageId){
		return Response.ok(commentAssembler.toResources(commentServcie.getAllComments(messageId)))
				.build();
	}

    @GET
    @Path("/{commentId}")
    public Response getCommentById(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId) {
        return Response.ok(commentAssembler.toResource(commentServcie.getCommentById(messageId, commentId)))
				.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment addComment(@PathParam("messageId") Long messageId, Comment comment) {
        return commentServcie.addComment(messageId, comment);
    }

    @PUT
    @Path("/{commentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId, Comment comment) {
    	comment.setCommentId(commentId);
    	comment.setCreatedDate(new Date());
        return commentServcie.updateComment(messageId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    public Comment deleteComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId) {
        return commentServcie.deleteComment(messageId, commentId);
    }

}

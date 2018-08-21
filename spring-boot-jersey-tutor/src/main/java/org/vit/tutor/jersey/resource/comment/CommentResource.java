package org.vit.tutor.jersey.resource.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vit.tutor.jersey.model.Comment;
import org.vit.tutor.jersey.service.comment.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.Date;
import java.util.List;

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

    @GET
    @Path("/{commentId}")
    public Comment getCommentById(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId) {
        return commentServcie.getCommentById(messageId, commentId);
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

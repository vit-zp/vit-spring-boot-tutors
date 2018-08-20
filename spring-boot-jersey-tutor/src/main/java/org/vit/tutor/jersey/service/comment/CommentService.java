package org.vit.tutor.jersey.service.comment;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vit.tutor.jersey.model.Comment;

@Service
public interface CommentService {
	
	List<Comment> getAllComments(Long messageId);
	
	Comment addComment(Long messageId, Comment comment);
	
	Comment updateComment(Long messageId, Comment comment);
	
	Comment deleteComment(Long messageId, Comment comment);

}

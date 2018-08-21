package org.vit.tutor.jersey.service.comment;

import org.springframework.stereotype.Service;
import org.vit.tutor.jersey.model.Comment;

import java.util.List;

@Service
public interface CommentService {
	
	List<Comment> getAllComments(Long messageId);
	
	Comment addComment(Long messageId, Comment comment);
	
	Comment updateComment(Long messageId, Comment comment);
	
	Comment deleteComment(Long messageId, Comment comment);

	Comment getCommentById(Long messageId, Long commentId);
}

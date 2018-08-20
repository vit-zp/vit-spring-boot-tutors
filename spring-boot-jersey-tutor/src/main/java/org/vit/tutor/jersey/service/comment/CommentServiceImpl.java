package org.vit.tutor.jersey.service.comment;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vit.tutor.jersey.database.DatabaseSimulationStuff;
import org.vit.tutor.jersey.model.Comment;

@Component
public class CommentServiceImpl implements CommentService {

	@Autowired
	private DatabaseSimulationStuff databaseService;
	
	@Override
	public List<Comment> getAllComments(Long messageId) {
		return getCommentsByMessageId(messageId)
				.values().stream().collect(Collectors.toList());
	}

	private Map<Long, Comment> getCommentsByMessageId(Long messageId) {
		return databaseService.getAllMessages().get(messageId)
				.getComments();
	}

	@Override
	public Comment addComment(Long messageId, Comment comment) {
		return getCommentsByMessageId(messageId)
				.put(1L + getCommentsByMessageId(messageId).size(), comment);
	}

	@Override
	public Comment updateComment(Long messageId, Comment comment) {
		return getCommentsByMessageId(messageId).put(comment.getCommentId(), comment);
	}

	@Override
	public Comment deleteComment(Long messageId, Comment comment) {
		return getCommentsByMessageId(messageId).remove(comment.getCommentId());
	}

}

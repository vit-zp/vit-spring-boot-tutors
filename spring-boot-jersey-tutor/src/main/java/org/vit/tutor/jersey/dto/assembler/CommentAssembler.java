package org.vit.tutor.jersey.dto.assembler;

import java.util.List;

import org.springframework.stereotype.Component;
import org.vit.tutor.jersey.dto.CommentDTO;
import org.vit.tutor.jersey.model.Comment;
import org.vit.tutor.jersey.resource.comment.CommentResource;

@Component
public class CommentAssembler extends AbstractJaxRsResourceAssemblerSupport<Comment, CommentDTO>{

	public CommentAssembler() {
		super(CommentResource.class, CommentDTO.class);
	}

	@Override
	public CommentDTO toResource(Comment entity) {
		return createResourceWithId(entity.getCommentId(), entity);
	}

	@Override
	public List<CommentDTO> toResources(Iterable<? extends Comment> entities) {
		// TODO Auto-generated method stub
		return super.toResources(entities);
	}
	
	

}

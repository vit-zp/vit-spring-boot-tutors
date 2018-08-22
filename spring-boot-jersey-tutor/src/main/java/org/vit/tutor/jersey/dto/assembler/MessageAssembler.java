package org.vit.tutor.jersey.dto.assembler;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vit.tutor.jersey.dto.MessageDTO;
import org.vit.tutor.jersey.model.Message;
import org.vit.tutor.jersey.resource.message.MessageResource;

@Component
public class MessageAssembler extends AbstractJaxRsResourceAssemblerSupport<Message, MessageDTO>{
	
	@Autowired
	CommentAssembler commentAssembler;

	public MessageAssembler() {
		super(MessageResource.class, MessageDTO.class);
	}

	@Override
	public MessageDTO toResource(Message entity) {
		MessageDTO result = createResourceWithId(entity.getId(), entity);
		result.setCreatedDate(entity.getCreatedDate());
		result.setMessageId(entity.getId());
		result.setMessageText(entity.getMessageText());
		result.setComments(commentAssembler.toResources(entity.getComments().values()).stream().collect(Collectors.toSet()));
		return result;
	}

}

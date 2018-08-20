package org.vit.tutor.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.vit.tutor.jersey.resource.comment.CommentResource;
import org.vit.tutor.jersey.resource.message.MessageResource;

@Configuration
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(MessageResource.class);
		register(CommentResource.class);
	}
	

}

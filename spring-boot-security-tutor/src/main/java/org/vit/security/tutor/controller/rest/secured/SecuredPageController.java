package org.vit.security.tutor.controller.rest.secured;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;

@RestController
@Log
public class SecuredPageController {
	
	
	private static final String SECURED_INFO = "It's a secured info...";

	@GetMapping("/secured")
	public String secured() {
		log.info(SECURED_INFO);
		return SECURED_INFO;
	}

}

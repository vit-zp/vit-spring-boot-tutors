package org.vit.security.tutor.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;

@RestController
@Log
public class HomeController {
	
	private static final String APP_IS_UP_AND_RUNNING = "App is up and running...";

	@GetMapping("/about")
	public String about() {
		log.info(APP_IS_UP_AND_RUNNING);
		return APP_IS_UP_AND_RUNNING;
	}

}

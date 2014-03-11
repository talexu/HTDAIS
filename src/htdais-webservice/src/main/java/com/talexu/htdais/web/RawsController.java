package com.talexu.htdais.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawsController {

	Logger logger = LoggerFactory.getLogger(RawsController.class);

	@RequestMapping("/raws")
	public String index() {
		logger.info("Greetings from Spring Boot!");
		return "Greetings from Spring Boot!";
	}
}

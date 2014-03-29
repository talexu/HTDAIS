package com.talexu.htdais.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RawsController {

	Logger logger = LoggerFactory.getLogger(RawsController.class);

	@RequestMapping("/")
	public String index() {
		logger.info("Greetings from Spring Boot!");
		return "index";
	}
}

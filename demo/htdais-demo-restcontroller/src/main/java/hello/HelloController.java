package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/")
	public String index() {
		logger.info("Greetings from Spring Boot!");
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/", produces = "application/json")
	public String indexJson() {
		logger.info("Greetings from Json!");
		return "Greetings from Json!";
	}
}

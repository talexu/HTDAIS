package com.talexu.htdais.web;

import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawsController {

	Logger logger = LoggerFactory.getLogger(RawsController.class);

	@RequestMapping("/raws")
	public String index() {
//		logger.info("Greetings from Spring Boot!");
//		return "Greetings from Spring Boot!";
		List<Term> parse = ToAnalysis.parse("让战士们过一个欢乐祥和的新春佳节。");
//	    System.out.println(parse);
	    return parse.toString();
	}
}

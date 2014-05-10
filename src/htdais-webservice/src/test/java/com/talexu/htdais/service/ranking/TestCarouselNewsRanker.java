package com.talexu.htdais.service.ranking;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class TestCarouselNewsRanker {

	Logger logger = LoggerFactory.getLogger(TestCarouselNewsRanker.class);

	@Autowired
	@Qualifier("carouselNewsRanker")
	NewsRanker carouselNewsRanker;

	@Test
	public void testExecute() {
		Pattern imgSrcPattern = Pattern.compile("^http.*?.jpg$",
				Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

		Matcher matcher = imgSrcPattern
				.matcher("http://image13-c.poco.cn/mypoco/myphoto/20121007/17/43847200201210071724162935008641488_000_640.jpg");
		logger.debug("{}", matcher.find());
		matcher = imgSrcPattern.matcher("");
		logger.debug("{}", matcher.find());
	}

}

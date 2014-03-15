package com.talexu.htdais.service.processor;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.ultility.TestData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class TestHtmlProcessor {

	@Autowired
	@Qualifier("htmlProcessor")
	NewsProcessor newsProcessor;

	List<QuantizedNews> quantizedNewses;

	@Before
	public void setUp() throws Exception {
		quantizedNewses = TestData.getInstance().getQuantizedNewses();
	}

	@Test
	public void testExecute() {
		for (QuantizedNews quantizedNews : quantizedNewses) {
			assertTrue(newsProcessor instanceof HtmlProcessor);
			QuantizedNews result = newsProcessor.execute(quantizedNews);
			System.out.println(result.getUri());
			System.out.println(result.getIsTheme());
			System.out.println(result.getTitle());
			System.out.println(result.getMainbody());
			System.out.println(result.getImage());
		}
	}

}

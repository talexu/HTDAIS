package com.talexu.htdais.service.processor;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.ultility.TestData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class TestClusterProcessor {

	Logger logger = LoggerFactory.getLogger(TestClusterProcessor.class);

	@Autowired
	@Qualifier("clusterProcessor")
	NewsProcessor newsProcessor;

	ClusterMatcher clusterMatcher;

	List<QuantizedNews> quantizedNewses;

	@Before
	public void setUp() throws Exception {
		quantizedNewses = TestData.getInstance().getQuantizedNewses();
	}

	@Test
	public void testExecute() {
		for (QuantizedNews quantizedNews : quantizedNewses) {
			quantizedNews = newsProcessor.execute(quantizedNews);
			assertTrue(quantizedNews instanceof QuantizedNews);

			logger.debug(quantizedNews.toString());
		}
	}

}

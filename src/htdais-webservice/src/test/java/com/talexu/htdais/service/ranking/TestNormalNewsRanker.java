package com.talexu.htdais.service.ranking;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.processor.NewsProcessor;
import com.talexu.htdais.service.processor.TestClusterProcessor;
import com.talexu.htdais.service.ultility.TestData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class TestNormalNewsRanker {

	Logger logger = LoggerFactory.getLogger(TestNormalNewsRanker.class);

	@Autowired
	@Qualifier("htmlProcessor")
	NewsProcessor newsProcessor;

	NormalNewsRanker normalNewsRanker = new NormalNewsRanker();
	List<QuantizedNews> quantizedNewses;

	@Before
	public void setUp() throws Exception {
		quantizedNewses = TestData.getInstance().getQuantizedNewses();
		for (QuantizedNews quantizedNew : quantizedNewses) {
			newsProcessor.execute(quantizedNew);
//			logger.debug("{}", quantizedNew);
		}
	}

	@Test
	public void testExecute() {
		quantizedNewses = normalNewsRanker.execute(quantizedNewses);
		for (QuantizedNews quantizedNew : quantizedNewses) {
			logger.debug("{}", quantizedNew);
		}
	}

	@Test
	public void testGetClusterMatcher() {
		// fail("Not yet implemented");
	}

	@Test
	public void testSetClusterMatcher() {
		// fail("Not yet implemented");
	}

	@Test
	public void testNormalNewsRanker() {
		// fail("Not yet implemented");
	}

	@Test
	public void testNormalNewsRankerNewsRanker() {
		// fail("Not yet implemented");
	}

	@Test
	public void testInitRankingPrameters() {
		// fail("Not yet implemented");
	}

	@Test
	public void testGenerateNormalDistribution() {
		// fail("Not yet implemented");
	}

}

package com.talexu.htdais.service.ranking;

import java.util.Calendar;

import java_cup.internal_error;

import org.apache.commons.math3.distribution.MultivariateNormalDistribution;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class TestNormalNewsRanker {

	Logger logger = LoggerFactory.getLogger(TestNormalNewsRanker.class);

	NormalNewsRanker normalNewsRanker = new NormalNewsRanker();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExecute() {
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
		Calendar now = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();

		MultivariateNormalDistribution multivariateNormalDistribution = normalNewsRanker
				.generateNormalDistribution(new double[] { 0, 0 },
						new double[][] { { 1, 0 }, { 0, 0.1 } });
		double[][] testData = new double[50][2];

		// 簇大小恒定为50，时间递增10分钟
		logger.debug("簇大小恒定为50，时间递增10分钟");
		for (int i = 0; i < testData.length; i++) {
			testData[i][0] = 0;
			testData[i][1] = (1 - (double) calendar.getTimeInMillis()
					/ now.getTimeInMillis()) * 36000;
			calendar.add(Calendar.MINUTE, -10);
		}

		for (double[] ds : testData) {
			logger.debug("{}, {}", ds,
					multivariateNormalDistribution.density(ds));
		}

		// 时间恒定，簇大小递减1
		logger.debug("时间恒定，簇大小递减1");
		for (int i = 0; i < testData.length; i++) {
			testData[i][0] = (1 - (double) (50 - i) / 50);
			testData[i][1] = 0;
		}

		for (double[] ds : testData) {
			logger.debug("{}, {}", ds,
					multivariateNormalDistribution.density(ds));
		}

		// 簇大小递减1，时间递减10分钟
		logger.debug("簇大小递减1，时间递减10分钟");
		now = Calendar.getInstance();
		calendar = Calendar.getInstance();
		for (int i = 0; i < testData.length; i++) {
			testData[i][0] = (1 - (double) (50 - i) / 50);
			testData[i][1] = (1 - (double) calendar.getTimeInMillis()
					/ now.getTimeInMillis()) * 36000;
			calendar.add(Calendar.MINUTE, -10);
		}

		for (double[] ds : testData) {
			logger.debug("{}, {}", ds,
					multivariateNormalDistribution.density(ds));
		}
	}

}

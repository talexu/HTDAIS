package com.talexu.htdais.service.statistics;

import java.util.Calendar;

import org.junit.Before;
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
public class TestTwoDimentionalStandardNormalDistribution {

	Logger logger = LoggerFactory
			.getLogger(TestTwoDimentionalStandardNormalDistribution.class);

	@Autowired
	@Qualifier("twoDimentionalStandardNormalDistribution")
	TwoDimentionalStandardNormalDistribution twoDimentionalStandardNormalDistribution;

	private double standardNormalBoundary = 1.96;
	private double timeStandardFactor = standardNormalBoundary / 86400000;
	private double clusterStandardFactor;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() {
		logger.debug("簇大小不变，时间递增10分钟");
		displayDensity(getTestData1());
		logger.debug("簇大小递减，时间不变");
		displayDensity(getTestData2());
		logger.debug("簇大小递减，时间递增10分钟");
		displayDensity(getTestData3());
	}

	private double[][] getTestData1() {
		Calendar now = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();

		double[][] testData = new double[50][2];

		// 簇大小不变，时间递增10分钟
		for (int i = 0; i < testData.length; i++) {
			testData[i][0] = 0;
			testData[i][1] = new Long(now.getTimeInMillis()
					- calendar.getTimeInMillis()).doubleValue()
					* timeStandardFactor;
			calendar.add(Calendar.MINUTE, -30);
		}

		return testData;
	}

	private double[][] getTestData2() {
		double[][] testData = new double[50][2];
		clusterStandardFactor = standardNormalBoundary / (50 - 0);

		// 簇大小递减，时间不变
		for (int i = 0; i < testData.length; i++) {
			testData[i][0] = i * clusterStandardFactor;
			testData[i][1] = 0;
		}

		return testData;
	}

	private double[][] getTestData3() {
		Calendar now = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();

		double[][] testData = new double[50][2];
		clusterStandardFactor = standardNormalBoundary / (50 - 0);

		// 簇大小递减，时间递增10分钟
		for (int i = 0; i < testData.length; i++) {
			testData[i][0] = i * clusterStandardFactor;
			testData[i][1] = new Long(now.getTimeInMillis()
					- calendar.getTimeInMillis())
					* timeStandardFactor;
			calendar.add(Calendar.MINUTE, -30);
		}

		return testData;
	}

	private void displayDensity(double[][] testData) {
		for (double[] ds : testData) {
			logger.debug("{}, {}", ds,
					twoDimentionalStandardNormalDistribution.getDensity(ds));
		}
	}
}

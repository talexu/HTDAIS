package com.talexu.htdais.service.ranking;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.math3.distribution.MultivariateNormalDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.processor.ClusterMatcher;

public class NormalNewsRanker extends NewsRankerDecorator {

	Logger logger = LoggerFactory.getLogger(NormalNewsRanker.class);

	private ClusterMatcher clusterMatcher;

	public ClusterMatcher getClusterMatcher() {
		return clusterMatcher;
	}

	public void setClusterMatcher(ClusterMatcher clusterMatcher) {
		this.clusterMatcher = clusterMatcher;
	}

	public NormalNewsRanker() {
		super();
	}

	public NormalNewsRanker(NewsRanker newsRanker) {
		super(newsRanker);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 设置排序参数（所属簇）
	 * 
	 * @param quantizedNews
	 * @return
	 */
	protected List<QuantizedNews> initRankingPrameters(
			List<QuantizedNews> quantizedNews) {
		// //
		// 分好簇后，滤掉没有簇的news，并从quantizedNews中获取所有簇，按照簇的大小和时间，建立正态分布模型，然后设定ranking值
		// List<QuantizedNews> clusteredNews = clusterMatcher
		// .matchCluster(quantizedNews);
		// List<QuantizedNews> filteredNews = new LinkedList<>();
		// double maximumClusterSize = 0;
		//
		// for (QuantizedNews clusteredNew : clusteredNews) {
		// Cluster cluster = clusteredNew.getCluster();
		// if (cluster != null) {
		// // 过滤
		// filteredNews.add(clusteredNew);
		// // 找到最大簇的大小
		// maximumClusterSize = Math.max(maximumClusterSize,
		// cluster.getWeight());
		// }
		// }
		//
		// Date date = new Date();
		// long now = date.getTime();
		// // 用当前时间作为中值，最大簇的大小作为中值，建立模型。
		//
		// return clusteredNews;

		Random random = new Random();
		MultivariateNormalDistribution multivariateNormalDistribution = generateNormalDistribution(
				new double[] { 10, 1 },
				new double[][] { { 10, 0 }, { 0, 0.1 } });
		for (QuantizedNews quantizedNew : quantizedNews) {
			int clusterSize = random.nextInt(20);
			double time = (double) quantizedNew.getCalendar().getTimeInMillis()
					/ Calendar.getInstance().getTimeInMillis();
			logger.debug("cluster size = {}", clusterSize);
			logger.debug("time = {}", time);
			double ranking = multivariateNormalDistribution
					.density(new double[] { clusterSize, time });
			logger.debug("ranking = {}", ranking);
			quantizedNew.setRanking(ranking);
		}

		return quantizedNews;
	}

	public MultivariateNormalDistribution generateNormalDistribution(
			double[] mu, double[][] sigma) {
		return new MultivariateNormalDistribution(mu, sigma);
	}

	@Override
	public List<QuantizedNews> execute(List<QuantizedNews> quantizedNews) {
		List<QuantizedNews> normalizedNews = initRankingPrameters(super
				.execute(quantizedNews));
		return normalizedNews;
	}
}

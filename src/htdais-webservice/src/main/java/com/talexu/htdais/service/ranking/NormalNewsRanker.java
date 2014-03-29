package com.talexu.htdais.service.ranking;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import moa.cluster.Cluster;

import org.apache.commons.math3.distribution.MultivariateNormalDistribution;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.processor.ClusterMatcher;

public class NormalNewsRanker extends NewsRankerDecorator {

	private ClusterMatcher clusterMatcher;

	private double[] mu = { 2, 1 };
	private double[][] sigma = { { 1, 0 }, { 0, 0.25 } };
	private MultivariateNormalDistribution distribution = new MultivariateNormalDistribution(
			mu, sigma);

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
		// 分好簇后，滤掉没有簇的news，并从quantizedNews中获取所有簇，按照簇的大小和时间，建立正态分布模型，然后设定ranking值
		List<QuantizedNews> clusteredNews = clusterMatcher.matchCluster(quantizedNews);
		List<QuantizedNews> filteredNews = new LinkedList<>();
		double maximumClusterSize = 0;
		
		for (QuantizedNews clusteredNew : clusteredNews) {
			Cluster cluster = clusteredNew.getCluster();
			if (cluster != null) {
				// 过滤
				filteredNews.add(clusteredNew);
				// 找到最大簇的大小
				maximumClusterSize = Math.max(maximumClusterSize, cluster.getWeight());
			}
		}
		
		Date date = new Date();
		long now = date.getTime();
		// 用当前时间作为中值，最大簇的大小作为中值，建立模型。
		
		
		return clusteredNews;
	}

	@Override
	public List<QuantizedNews> execute(List<QuantizedNews> quantizedNews) {
		List<QuantizedNews> normalizedNews = initRankingPrameters(super
				.execute(quantizedNews));
		return normalizedNews;
	}

}

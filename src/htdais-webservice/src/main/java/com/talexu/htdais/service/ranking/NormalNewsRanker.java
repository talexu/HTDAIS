package com.talexu.htdais.service.ranking;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import moa.cluster.Cluster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.processor.ClusterMatcher;
import com.talexu.htdais.service.statistics.DistributionProcessor;

public class NormalNewsRanker extends NewsRankerDecorator {

	Logger logger = LoggerFactory.getLogger(NormalNewsRanker.class);

	private double standardNormalBoundary = 1.96;
	private double timeStandardFactor = 86400000 / standardNormalBoundary;
	private double clusterStandardFactor;

	private DistributionProcessor distributionProcessor;
	private ClusterMatcher clusterMatcher;

	public DistributionProcessor getDistributionProcessor() {
		return distributionProcessor;
	}

	public void setDistributionProcessor(
			DistributionProcessor distributionProcessor) {
		this.distributionProcessor = distributionProcessor;
	}

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
		List<QuantizedNews> clusteredNews = clusterMatcher
				.matchCluster(quantizedNews);

		List<QuantizedNews> filteredNews = new LinkedList<>();
		TreeSet<Cluster> sortedClusters = new TreeSet<>(
				new Comparator<Cluster>() {
					@Override
					public int compare(Cluster o1, Cluster o2) {
						return (new Double(o1.getWeight() - o2.getWeight()))
								.intValue();
					}
				});

		// 滤掉离群点
		for (QuantizedNews clusteredNew : clusteredNews) {
			Cluster cluster = clusteredNew.getCluster();
			if (cluster != null) {
				filteredNews.add(clusteredNew);
				sortedClusters.add(cluster);
			}
		}

		// 设置簇标准化参数
		Cluster minCluster = sortedClusters.first();
		Cluster maxCluster = sortedClusters.last();
		double minClusterSize = minCluster == null ? 0 : minCluster.getWeight();
		double maxClusterSize = maxCluster == null ? 0 : maxCluster.getWeight();
		double diffClusterSize = maxClusterSize - minClusterSize;
		clusterStandardFactor = diffClusterSize == 0 ? 0
				: standardNormalBoundary / diffClusterSize;

		/**
		 * 标准化参数并获取概率密度 簇大小参数为标准化的与最大簇的差 时间参数为标准化的与现在时间的差
		 */
		long now = Calendar.getInstance().getTimeInMillis();
		for (QuantizedNews filteredNew : filteredNews) {
			filteredNew.setRanking(distributionProcessor
					.getDensity(new double[] {
							(maxClusterSize - filteredNew.getCluster()
									.getWeight()) * clusterStandardFactor,
							new Long(now
									- filteredNew.getCalendar()
											.getTimeInMillis()).doubleValue()
									* timeStandardFactor }));
		}

		return filteredNews;
	}

	@Override
	public List<QuantizedNews> execute(List<QuantizedNews> quantizedNews) {
		// 设置Ranking值
		List<QuantizedNews> normalizedNews = initRankingPrameters(super
				.execute(quantizedNews));

		// 根据Ranking值排序
		Collections.sort(normalizedNews, new Comparator<QuantizedNews>() {
			@Override
			public int compare(QuantizedNews o1, QuantizedNews o2) {
				return (new Double(o1.getRanking() - o2.getRanking()))
						.intValue();
			}
		});

		return normalizedNews;
	}
}

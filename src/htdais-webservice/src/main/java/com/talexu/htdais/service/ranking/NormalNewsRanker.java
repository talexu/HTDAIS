package com.talexu.htdais.service.ranking;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.processor.ClusterMatcher;
import com.talexu.htdais.service.statistics.DistributionProcessor;

public class NormalNewsRanker extends NewsRankerDecorator {

	Logger logger = LoggerFactory.getLogger(NormalNewsRanker.class);

	private double standardNormalBoundary = 1.96;
	private double timeStandardFactor = standardNormalBoundary / 86400000;
	private double clusterStandardFactor;

	private DistributionProcessor distributionProcessor;
	private ClusterMatcher clusterMatcher;

	private ClusterSizeQuantizedNewsComparator clusterSizeQuantizedNewsComparator = new ClusterSizeQuantizedNewsComparator();

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
	 * 给新闻匹配簇
	 * 
	 * @param quantizedNews
	 * @return
	 */
	protected List<QuantizedNews> matchCluster(List<QuantizedNews> quantizedNews) {
		// 分好簇后，滤掉没有簇的news，并从quantizedNews中获取所有簇，按照簇的大小和时间，建立正态分布模型，然后设定ranking值
		List<QuantizedNews> clusteredNews = clusterMatcher
				.matchCluster(quantizedNews);

		return clusteredNews;
	}

	/**
	 * 滤掉没有簇的新闻
	 * 
	 * @param quantizedNews
	 * @return
	 */
	protected List<QuantizedNews> filterUnclusteredNews(
			List<QuantizedNews> quantizedNews) {
		List<QuantizedNews> unclusteredNews = new LinkedList<>();
		for (QuantizedNews quantizedNew : quantizedNews) {
			if (quantizedNew.getCluster() != null) {
				unclusteredNews.add(quantizedNew);
			}
		}

		return unclusteredNews;
	}

	/**
	 * 设置排序参数（所属簇）
	 * 
	 * @param quantizedNews
	 * @return
	 */
	protected List<QuantizedNews> initRankingPrameters(
			List<QuantizedNews> quantizedNews) {
		QuantizedNews newsWithMinCluster = Collections.min(quantizedNews,
				clusterSizeQuantizedNewsComparator);
		QuantizedNews newsWithMaxCluster = Collections.max(quantizedNews,
				clusterSizeQuantizedNewsComparator);

		if (newsWithMinCluster != null && newsWithMaxCluster != null) {
			double maxClusterSize = newsWithMaxCluster.getCluster().getWeight();
			double minClusterSize = newsWithMinCluster.getCluster().getWeight();
			double diffClusterSize = maxClusterSize - minClusterSize;

			clusterStandardFactor = diffClusterSize == 0 ? 0
					: standardNormalBoundary / diffClusterSize;

			logger.debug("max cluster size = {}", maxClusterSize);
			logger.debug("min cluster size = {}", minClusterSize);
			logger.debug("clusterStandardFactor = {}", clusterStandardFactor);

			/**
			 * 标准化参数并获取概率密度 簇大小参数为标准化的与最大簇的差 时间参数为标准化的与现在时间的差
			 */
			// long now = Calendar.getInstance().getTimeInMillis();
			Calendar calendar = Calendar.getInstance();
			calendar.set(2014, 1, 23, 12, 0, 0);
			long now = calendar.getTimeInMillis();

			logger.debug("now: {}", calendar.getTime());

			for (QuantizedNews filteredNew : quantizedNews) {
				double[] v = new double[] {
						(maxClusterSize - filteredNew.getCluster().getWeight())
								* clusterStandardFactor,
						new Long(now
								- filteredNew.getCalendar().getTimeInMillis())
								.doubleValue() * timeStandardFactor };
				logger.debug("{}, {}", v, distributionProcessor.getDensity(v));

				logger.debug("now is {}, calendar is {}", now, filteredNew
						.getCalendar().getTimeInMillis());

				filteredNew.setRanking(distributionProcessor
						.getDensity(new double[] {
								(maxClusterSize - filteredNew.getCluster()
										.getWeight()) * clusterStandardFactor,
								new Long(now
										- filteredNew.getCalendar()
												.getTimeInMillis())
										.doubleValue() * timeStandardFactor }));
			}
		}

		return quantizedNews;
	}

	@Override
	public List<QuantizedNews> execute(List<QuantizedNews> quantizedNews) {
		List<QuantizedNews> rankingNews = super.execute(quantizedNews);

		// 分配簇
		List<QuantizedNews> matchedNews = matchCluster(rankingNews);

		// 滤掉没有簇的新闻
		List<QuantizedNews> clusteredNews = filterUnclusteredNews(matchedNews);

		// 设置Ranking值
		List<QuantizedNews> normalizedNews = initRankingPrameters(clusteredNews);

		// 根据Ranking值排序
		Collections.sort(normalizedNews,
				Collections.reverseOrder(new Comparator<QuantizedNews>() {
					@Override
					public int compare(QuantizedNews o1, QuantizedNews o2) {
						return Double.compare(o1.getRanking(), o2.getRanking());
					}
				}));

		return normalizedNews;
	}
}

package com.talexu.htdais.service.ranking;

import java.util.List;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.processor.ClusterMatcher;

public class NormalNewsRanker extends NewsRankerDecorator {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuantizedNews> execute(List<QuantizedNews> quantizedNews) {
		return super.execute(quantizedNews);
	}

}

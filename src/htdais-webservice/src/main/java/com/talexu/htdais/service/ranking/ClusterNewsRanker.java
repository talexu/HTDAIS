package com.talexu.htdais.service.ranking;

import java.util.List;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.processor.ClusterMatcher;

public class ClusterNewsRanker extends NormalNewsRanker {

	private ClusterMatcher clusterMatcher;

	public ClusterMatcher getClusterMatcher() {
		return clusterMatcher;
	}

	public void setClusterMatcher(ClusterMatcher clusterMatcher) {
		this.clusterMatcher = clusterMatcher;
	}

	@Override
	protected List<QuantizedNews> initRankingPrameters(
			List<QuantizedNews> quantizedNews) {
		// TODO Auto-generated method stub
		return null;
	}

}

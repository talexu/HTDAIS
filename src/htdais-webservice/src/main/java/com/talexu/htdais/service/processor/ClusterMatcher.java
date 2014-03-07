package com.talexu.htdais.service.processor;

import java.util.Collection;

import com.talexu.htdais.domain.QuantizedNews;

public interface ClusterMatcher {

	public QuantizedNews matchCluster(QuantizedNews quantizedNews);

	public Collection<QuantizedNews> matchCluster(
			Collection<QuantizedNews> quantizedNews);
}

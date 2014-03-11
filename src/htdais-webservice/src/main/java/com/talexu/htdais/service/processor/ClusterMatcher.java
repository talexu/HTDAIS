package com.talexu.htdais.service.processor;

import java.util.List;

import com.talexu.htdais.domain.QuantizedNews;

public interface ClusterMatcher {

	public QuantizedNews matchCluster(QuantizedNews quantizedNews);

	public List<QuantizedNews> matchCluster(List<QuantizedNews> quantizedNews);
}

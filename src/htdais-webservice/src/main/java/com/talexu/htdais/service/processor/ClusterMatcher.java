package com.talexu.htdais.service.processor;

import java.util.List;

import moa.cluster.Cluster;
import moa.core.AutoExpandVector;

import com.talexu.htdais.domain.QuantizedNews;

public interface ClusterMatcher {

	public AutoExpandVector<Cluster> getClusters();

	public QuantizedNews matchCluster(QuantizedNews quantizedNews);

	public List<QuantizedNews> matchCluster(List<QuantizedNews> quantizedNews);
}

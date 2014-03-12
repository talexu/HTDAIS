package com.talexu.htdais.domain;

import moa.cluster.Cluster;

public class QuantizedNews extends News {

	private double[] vector;
	private Cluster cluster;

	public double[] getVector() {
		return vector;
	}

	public void setVector(double[] vector) {
		this.vector = vector;
	}

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public QuantizedNews() {
		super();
	}
}

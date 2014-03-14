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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		this.append(stringBuilder, super.toString());
		this.append(stringBuilder, this.getUri());
		this.append(stringBuilder, this.getIsTheme().toString());
		this.append(stringBuilder, this.getTitle());
		this.append(stringBuilder, this.getImage());
		this.append(stringBuilder, this.getKeywords().toString());
		this.append(stringBuilder, this.getSummary());
		this.append(stringBuilder, this.getMainbody());

		return stringBuilder.toString();
	}

	private StringBuilder append(StringBuilder stringBuilder, String string) {
		stringBuilder.append(string);
		stringBuilder.append(System.getProperty("line.separator"));
		return stringBuilder;
	}
}

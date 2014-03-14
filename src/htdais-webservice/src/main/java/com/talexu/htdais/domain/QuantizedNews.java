package com.talexu.htdais.domain;

import weka.core.Instance;
import moa.cluster.Cluster;

public class QuantizedNews extends News {

	private double[] vector;
	private Instance instance;
	private Cluster cluster;

	public double[] getVector() {
		return vector;
	}

	public void setVector(double[] vector) {
		this.vector = vector;
	}

	public Instance getInstance() {
		return instance;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
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

		if (vector != null) {
			StringBuilder vectorStringBuilder = new StringBuilder();
			for (double dimention : vector) {
				vectorStringBuilder.append(dimention);
				vectorStringBuilder.append(", ");
			}
			this.append(stringBuilder, vectorStringBuilder.toString());
		}

		if (this.getInstance() != null) {
			this.append(stringBuilder, this.getInstance().toString());
		}
		if (this.getCluster() != null) {
			this.append(stringBuilder, this.getCluster().toString());
		}

		return stringBuilder.toString();
	}

	private StringBuilder append(StringBuilder stringBuilder, String string) {
		stringBuilder.append(string);
		stringBuilder.append(System.getProperty("line.separator"));
		return stringBuilder;
	}
}

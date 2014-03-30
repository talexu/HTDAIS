package com.talexu.htdais.domain;

import weka.core.Instance;
import moa.cluster.Cluster;

public class QuantizedNews extends News {

	private double[] vector;
	private Instance instance;
	private Cluster cluster;

	private double ranking;

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

	public double getRanking() {
		return ranking;
	}

	public void setRanking(double ranking) {
		this.ranking = ranking;
	}

	public QuantizedNews() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		this.append(stringBuilder, "QuantizedNews", super.toString());
		this.append(stringBuilder, "uri", this.getUri());
		this.append(stringBuilder, "calendar", this.getCalendar().toString());
		this.append(stringBuilder, "is theme", this.getIsTheme().toString());
		this.append(stringBuilder, "title", this.getTitle());
		this.append(stringBuilder, "image", this.getImage());
		this.append(stringBuilder, "keywords", this.getKeywords().toString());
		this.append(stringBuilder, "summary", this.getSummary());
		this.append(stringBuilder, "mainbody", this.getMainbody());

		// if (vector != null) {
		// StringBuilder vectorStringBuilder = new StringBuilder();
		// for (double dimention : vector) {
		// vectorStringBuilder.append(dimention);
		// vectorStringBuilder.append(", ");
		// }
		// this.append(stringBuilder, "uri", vectorStringBuilder.toString());
		// }

		if (this.getInstance() != null) {
			this.append(stringBuilder, "instance", this.getInstance()
					.toString());
		}
		if (this.getCluster() != null) {
			this.append(stringBuilder, "cluster", this.getCluster().toString());
		}
		this.append(stringBuilder, "ranking",
				Double.toString(this.getRanking()));

		return stringBuilder.toString();
	}

	private StringBuilder append(StringBuilder stringBuilder, String header,
			String string) {
		stringBuilder.append("---------------");
		stringBuilder.append(header);
		stringBuilder.append("---------------");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(string);
		stringBuilder.append(System.getProperty("line.separator"));
		return stringBuilder;
	}
}

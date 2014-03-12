package com.talexu.htdais.service.processor;

import java.util.List;

import moa.options.FloatOption;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.cluster.HtdaisClusterer;

public class ClusterProcessor extends NewsProcessorDecorator implements
		ClusterMatcher {

	private HtdaisClusterer htdaisClusterer;
	private float eps = 0.02f;
	private int minPoints = 1;
	private int initPoints = 10;
	private float epsMin = 0f;
	private float epsMax = 2f;

	public float getEps() {
		return eps;
	}

	public void setEps(float eps) {
		this.eps = eps;
	}

	public int getMinPoints() {
		return minPoints;
	}

	public void setMinPoints(int minPoints) {
		this.minPoints = minPoints;
	}

	public int getInitPoints() {
		return initPoints;
	}

	public void setInitPoints(int initPoints) {
		this.initPoints = initPoints;
	}

	public ClusterProcessor() {
		super();
		initClusterer();
	}

	public ClusterProcessor(NewsProcessor newsProcessor) {
		super(newsProcessor);
		initClusterer();
	}

	public ClusterProcessor(NewsProcessor newsProcessor, float eps, int min,
			int init) {
		super(newsProcessor);

		setEps(eps);
		setMinPoints(min);
		setInitPoints(init);
		initClusterer();
	}

	protected void initClusterer() {
		htdaisClusterer = new HtdaisClusterer();
		htdaisClusterer.epsilonOption = new FloatOption("epsilon", 'e',
				"Defines the epsilon neighbourhood", getEps(), epsMin, epsMax);
		htdaisClusterer.muOption.setValue(getMinPoints());
		// 50 samples
		// 0.07, 1 -> 25 clusters
		htdaisClusterer.initPointsOption.setValue(getInitPoints());
		htdaisClusterer.prepareForUse();
	}

	@Override
	public QuantizedNews execute(QuantizedNews quantizedNews) {
		// TODO
		return super.execute(quantizedNews);
	}

	@Override
	public QuantizedNews matchCluster(QuantizedNews quantizedNews) {
		// TODO Auto-generated method stub
		return quantizedNews;
	}

	@Override
	public List<QuantizedNews> matchCluster(List<QuantizedNews> quantizedNews) {
		// TODO Auto-generated method stub
		return quantizedNews;
	}
}

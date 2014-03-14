package com.talexu.htdais.service.processor;

import java.util.ArrayList;
import java.util.List;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import moa.cluster.Cluster;
import moa.core.AutoExpandVector;
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

	private int dimention = 201;
	private Instances instances;

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

		ArrayList<Attribute> attributes = new ArrayList<Attribute>(dimention);
		for (int i = 1; i <= dimention; i++) {
			attributes.add(new Attribute("Dimension" + i));
		}
		instances = new Instances("vector", attributes, 0);
		instances.setClassIndex(dimention - 1);
	}

	@Override
	public QuantizedNews execute(QuantizedNews quantizedNews) {
		QuantizedNews result = super.execute(quantizedNews);

		double[] vector = initializeVector(result.getVector());
		if (vector != null) {
			Instance instance = new DenseInstance(1, vector);
			instance.setDataset(instances);
			htdaisClusterer.trainOnInstance(instance);
			
			result.setInstance(instance);
		}

		return result;
	}

	protected double[] initializeVector(double[] vector) {
		if (vector != null) {
			int size = vector.length;
			double[] result = new double[size + 1];
			for (int i = 0; i < size; i++) {
				result[i] = vector[i];
			}
			return result;
		}

		return vector;
	}

	public QuantizedNews matchCluster(QuantizedNews quantizedNews) {
		return matchCluster(getClusters(), quantizedNews);
	}

	public QuantizedNews matchCluster(AutoExpandVector<Cluster> clusters,
			QuantizedNews quantizedNews) {
		double maxProbability = 0;
		for (Cluster cluster : clusters) {
			double probability = cluster.getInclusionProbability(quantizedNews
					.getInstance());
			if (probability > maxProbability) {
				quantizedNews.setCluster(cluster);
				maxProbability = probability;
			}
		}
		return quantizedNews;
	}

	public List<QuantizedNews> matchCluster(List<QuantizedNews> quantizedNews) {
		AutoExpandVector<Cluster> clusters = getClusters();
		for (QuantizedNews quantizedNew : quantizedNews) {
			matchCluster(clusters, quantizedNew);
		}
		return quantizedNews;
	}

	@Override
	public AutoExpandVector<Cluster> getClusters() {
		return htdaisClusterer.copy().getClusteringResult().getClustering();
	}
}

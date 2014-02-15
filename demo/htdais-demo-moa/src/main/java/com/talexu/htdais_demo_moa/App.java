package com.talexu.htdais_demo_moa;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import moa.cluster.Cluster;
import moa.clusterers.ClusterGenerator;
import moa.clusterers.Clusterer;
import moa.clusterers.denstream.WithDBSCAN;
import moa.streams.clustering.RandomRBFGeneratorEvents;

/**
 * Hello world!
 * 
 */
public class App {
	static RandomRBFGeneratorEvents randomRBFGenerator;
//	static Clusterer clusterer = new ClusterGenerator();
	static WithDBSCAN clusterer = new WithDBSCAN();
	static WithDBSCAN denStream = new WithDBSCAN();

	public static void main(String[] args) {
		
		
		randomGenerator();
//		randomFromVectors();
	}
	
	private static void randomFromVectors() {
		denStream.prepareForUse();
		
		Word2Vec vec = new Word2Vec();
    	try {
			vec.loadModel("/Users/bjutales/Documents/Development/Resources/vectors.bin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Instances instances = null;
    	int count=0;
    	int limit = 5000;
    	for (Entry<String, double[]> entry : vec.getWordMap().entrySet()) {
    		if (instances == null) {
    			ArrayList<Attribute> attributes = new ArrayList<Attribute>(entry.getValue().length);
    			for (int i = 1; i <= entry.getValue().length; i++) {
    				attributes.add(new Attribute("Dimension" + i));
				}
    			instances = new Instances("vector", attributes, 0);
    			instances.setClassIndex(entry.getValue().length - 1);
			}
			Instance instance = new DenseInstance(1, entry.getValue());
			instance.setDataset(instances);
			denStream.trainOnInstance(instance);
			System.out.println(count++);
			if(limit-- == 0)break;
		}
    	
		System.out.println(denStream.getClusteringResult().size());
		for (Cluster cluster : denStream.getClusteringResult().getClustering()) {
			System.out.println(cluster.getInfo());
		}
	}
	
	private static void randomGenerator() {
		randomRBFGenerator = new RandomRBFGeneratorEvents();
		randomRBFGenerator.numAttsOption.setValue(3);
		randomRBFGenerator.numClusterOption.setValue(5);
		randomRBFGenerator.prepareForUse();

		clusterer.prepareForUse();
		
		Instance generatedInstance = null;
		for (int i = 0; i < 5000; i++) {
			generatedInstance = randomRBFGenerator.nextInstance();
//			System.out.println(generatedInstance.classAttribute());
			clusterer.trainOnInstance(generatedInstance);
		}

		System.out.println(clusterer.getClusteringResult().size());
		for (Cluster cluster : clusterer.getClusteringResult().getClustering()) {
			System.out.println(cluster.getInfo());
		}
		Instance testInstance = new DenseInstance(1.0, new double[] { 0.79,
				0.56, 0.56, 1 });
		for (Cluster cluster : clusterer.getClusteringResult().getClustering()) {
			System.out.println(cluster.getInclusionProbability(testInstance));
		}
	}
}

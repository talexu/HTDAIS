package com.talexu.htdais_demo_moa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;

import moa.cluster.Cluster;
import moa.clusterers.denstream.WithDBSCAN;
import moa.options.FloatOption;
import moa.streams.clustering.RandomRBFGeneratorEvents;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import com.talexu.htdais_demo_moa.Word2Vec.WordEntry;

/**
 * Hello world!
 * 
 */
public class App {
	static RandomRBFGeneratorEvents randomRBFGenerator;
	// static Clusterer clusterer = new ClusterGenerator();
	static WithDBSCAN clusterer = new WithDBSCAN();
	static WithDBSCAN denStream = new VectorWithDBSCAN();

	public static void main(String[] args) {

		 randomGenerator();
		 
//		randomFromVectors();
	}

	private static void randomFromVectors() {
//		denStream.horizonOption.setValue(1);
		denStream.epsilonOption = new FloatOption("epsilon", 'e',
				"Defines the epsilon neighbourhood", 0.02, 0, 2);
		// 50 samples
		// 0.07, 1 -> 25 clusters
		denStream.initPointsOption.setValue(10);
		denStream.prepareForUse();
		

		Word2Vec vec = new Word2Vec();
		try {
			vec.loadModel("/Users/bjutales/Documents/Development/Resources/vectors.bin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Instances instances = null;
		int count = 0;
		int limit = 50;
		for (Entry<String, double[]> entry : vec.getWordMap().entrySet()) {
			if (instances == null) {
				ArrayList<Attribute> attributes = new ArrayList<Attribute>(
						entry.getValue().length);
				for (int i = 1; i <= entry.getValue().length; i++) {
					attributes.add(new Attribute("Dimension" + i));
				}
				instances = new Instances("vector", attributes, 0);
				instances.setClassIndex(entry.getValue().length - 1);
			}
			for (WordEntry relativeWord : vec.distance(entry.getKey())) {
				Instance instance = new DenseInstance(1, vec.getWordVector(relativeWord.name));
				instance.setDataset(instances);
				denStream.trainOnInstance(instance);
//				System.out.println(count++);
			}
			
			if (limit-- == 0)
				break;
		}

		System.out.println(denStream.getClusteringResult().size());
//		for (Cluster cluster : denStream.getClusteringResult().getClustering()) {
//			System.out.println(cluster.getInfo());
//		}
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
			// System.out.println(generatedInstance.classAttribute());
			clusterer.trainOnInstance(generatedInstance);
		}

		System.out.println(clusterer.getClusteringResult().size());
		for (Cluster cluster : clusterer.getClusteringResult().getClustering()) {
			System.out.println(cluster.getInfo());
//			System.out.println(cluster.getWeight());
		}
		Instance testInstance = new DenseInstance(1.0, new double[] { 0.79,
				0.56, 0.56, 1 });
		for (Cluster cluster : clusterer.getClusteringResult().getClustering()) {
			System.out.println(cluster.getInclusionProbability(testInstance));
		}
	}
}

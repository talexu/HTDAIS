package com.talexu.htdais.service.cluster;

import moa.clusterers.denstream.WithDBSCAN;

public class HtdaisClusterer extends WithDBSCAN {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3801769578808671727L;

	@Override
	protected double distance(double[] pointA, double[] pointB) {
		double distance = 0.0;
		for (int i = 0; i < pointA.length; i++) {
			distance += pointA[i] * pointB[i];
		}
//		System.out.println(1 - distance);
		return 1 - distance;
	}
}

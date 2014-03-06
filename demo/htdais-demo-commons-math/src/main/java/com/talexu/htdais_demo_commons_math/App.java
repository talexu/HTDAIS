package com.talexu.htdais_demo_commons_math;

import org.apache.commons.math3.distribution.MultivariateNormalDistribution;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		final double[] mu = { 2, 1 };
		final double[][] sigma = { { 1, 0 }, { 0, 0.25 } };
		final MultivariateNormalDistribution d = new MultivariateNormalDistribution(
				mu, sigma);
		System.out.println(d.density(new double[] { 1.5, 1 }));
	}
}

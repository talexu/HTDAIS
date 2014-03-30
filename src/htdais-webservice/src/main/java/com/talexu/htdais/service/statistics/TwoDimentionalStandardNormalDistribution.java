package com.talexu.htdais.service.statistics;

import org.apache.commons.math3.distribution.MultivariateNormalDistribution;

public class TwoDimentionalStandardNormalDistribution implements
		DistributionProcessor {

	private final double[] mu = new double[] { 0, 0 };
	private final double[][] sigma = new double[][] { { 1, 0 }, { 0, 1 } };

	private MultivariateNormalDistribution multivariateNormalDistribution;

	public TwoDimentionalStandardNormalDistribution() {
		multivariateNormalDistribution = new MultivariateNormalDistribution(mu,
				sigma);
	}

	@Override
	public double getDensity(double[] vals) {
		return multivariateNormalDistribution.density(vals);
	}

}

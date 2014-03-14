package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.word2vec.VectorCalculator;

public class VectorProcessor extends NewsProcessorDecorator {

	VectorCalculator vectorCalculator;

	public VectorCalculator getVectorCalculator() {
		return vectorCalculator;
	}

	public void setVectorCalculator(VectorCalculator vectorCalculator) {
		this.vectorCalculator = vectorCalculator;
	}

	public VectorProcessor() {

	}

	public VectorProcessor(NewsProcessor newsProcessor) {
		super(newsProcessor);
	}

	@Override
	public QuantizedNews execute(QuantizedNews quantizedNews) {
		QuantizedNews result = super.execute(quantizedNews);

		if (result != null) {
			double[] vector = vectorCalculator.getWordsVector(result
					.getKeywords());
			result.setVector(formatVector(vector));
		}

		return result;
	}

	protected double[] formatVector(double[] vector) {
//		if (vector != null) {
//			int size = vector.length;
//			double[] result = new double[size + 1];
//			for (int i = 0; i < size; i++) {
//				result[i] = vector[i];
//			}
//			return result;
//		}

		return vector;
	}
}

package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;

public class VectorProcessor extends NewsProcessorDecorator {

	public VectorProcessor() {

	}

	public VectorProcessor(NewsProcessor newsProcessor) {
		super(newsProcessor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public QuantizedNews execute(QuantizedNews quantizedNews) {
		// TODO
		return super.execute(quantizedNews);
	}
}

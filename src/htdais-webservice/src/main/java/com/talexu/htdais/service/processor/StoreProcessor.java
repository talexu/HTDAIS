package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;

public class StoreProcessor extends NewsProcessorDecorator {

	public StoreProcessor() {

	}

	public StoreProcessor(NewsProcessor newsProcessor) {
		super(newsProcessor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public QuantizedNews execute(QuantizedNews quantizedNews) {
		// TODO
		return super.execute(quantizedNews);
	}
}

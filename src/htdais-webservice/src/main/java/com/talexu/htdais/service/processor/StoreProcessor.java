package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;

public class StoreProcessor extends NewsProcessorDecorator {

	public StoreProcessor(NewsProcessor newsProcessor) {
		super(newsProcessor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(QuantizedNews quantizedNews) {
		// TODO
		super.process(quantizedNews);
	}
}

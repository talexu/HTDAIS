package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;

public class NewsProcessorDecorator implements NewsProcessor {

	protected NewsProcessor newsProcessor;

	public NewsProcessorDecorator(NewsProcessor newsProcessor) {
		this.newsProcessor = newsProcessor;
	}

	@Override
	public void process(QuantizedNews quantizedNews) {
		if (newsProcessor != null) {
			newsProcessor.process(quantizedNews);
		}
	}

}

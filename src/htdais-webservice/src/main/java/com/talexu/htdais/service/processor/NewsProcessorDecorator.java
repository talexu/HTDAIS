package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;

public abstract class NewsProcessorDecorator implements NewsProcessor {

	protected NewsProcessor newsProcessor;

	public NewsProcessorDecorator() {

	}

	public NewsProcessorDecorator(NewsProcessor newsProcessor) {
		this.newsProcessor = newsProcessor;
	}

	@Override
	public void execute(QuantizedNews quantizedNews) {
		if (newsProcessor != null) {
			newsProcessor.execute(quantizedNews);
		}
	}

}

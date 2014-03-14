package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;

public abstract class NewsProcessorDecorator implements NewsProcessor {

	protected NewsProcessor newsProcessor;

	public NewsProcessor getNewsProcessor() {
		return newsProcessor;
	}

	public void setNewsProcessor(NewsProcessor newsProcessor) {
		this.newsProcessor = newsProcessor;
	}

	public NewsProcessorDecorator() {

	}

	public NewsProcessorDecorator(NewsProcessor newsProcessor) {
		this.newsProcessor = newsProcessor;
	}

	public QuantizedNews execute(QuantizedNews quantizedNews) {
		if (newsProcessor != null) {
			return newsProcessor.execute(quantizedNews);
		}
		return quantizedNews;
	}

}

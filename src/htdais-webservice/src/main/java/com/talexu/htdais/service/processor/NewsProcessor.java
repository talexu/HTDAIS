package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;

public abstract class NewsProcessor {

	protected NewsProcessor newsProcessor;

	public NewsProcessor(NewsProcessor newsProcessor) {
		this.newsProcessor = newsProcessor;
	}

	public void process(QuantizedNews quantizedNews) {
		if (newsProcessor != null) {
			newsProcessor.process(quantizedNews);
		}
	}
}

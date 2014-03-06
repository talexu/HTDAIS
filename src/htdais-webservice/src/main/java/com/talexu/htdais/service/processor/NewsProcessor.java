package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;

public abstract class NewsProcessor {

	private NewsProcessor newsProcessor;

	public NewsProcessor(NewsProcessor newsProcessor) {
		this.newsProcessor = newsProcessor;
	}

	public void Process(QuantizedNews quantizedNews) {
		if (newsProcessor != null) {
			newsProcessor.Process(quantizedNews);
		}
	}
}

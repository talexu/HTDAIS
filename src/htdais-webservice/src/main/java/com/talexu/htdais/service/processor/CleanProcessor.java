package com.talexu.htdais.service.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.talexu.htdais.domain.QuantizedNews;

public class CleanProcessor extends NewsProcessorDecorator {
	
	Logger logger = LoggerFactory.getLogger(CleanProcessor.class);

	public CleanProcessor() {
		super();
	}

	public CleanProcessor(NewsProcessor newsProcessor) {
		super(newsProcessor);
	}

	@Override
	public QuantizedNews execute(QuantizedNews quantizedNews) {
		QuantizedNews result = super.execute(quantizedNews);
		if (result != null) {
			result.setHtml(null);
		}

		return result;
	}
}

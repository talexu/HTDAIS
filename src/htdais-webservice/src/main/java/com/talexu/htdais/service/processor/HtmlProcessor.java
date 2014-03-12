package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;

public class HtmlProcessor extends NewsProcessorDecorator {
	
	public HtmlProcessor() {
		super();
	}

	public HtmlProcessor(NewsProcessor newsProcessor) {
		super(newsProcessor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(QuantizedNews quantizedNews) {
		// TODO
		super.execute(quantizedNews);
	}
}

package com.talexu.htdais.service.processor;

import java.util.Map;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.html.BasicHtmlExtrator;
import com.talexu.htdais.service.html.HtmlExtrator;
import com.talexu.htdais.service.html.ImageHtmlExtrator;

public class HtmlProcessor extends NewsProcessorDecorator {

	HtmlExtrator htmlExtrator;

	public HtmlExtrator getHtmlExtrator() {
		return htmlExtrator;
	}

	public void setHtmlExtrator(HtmlExtrator htmlExtrator) {
		this.htmlExtrator = htmlExtrator;
	}

	public HtmlProcessor() {
		super();
	}

	public HtmlProcessor(NewsProcessor newsProcessor) {
		super(newsProcessor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public QuantizedNews execute(QuantizedNews quantizedNews) {
		QuantizedNews result = super.execute(quantizedNews);

		Map<String, String> extratorResults = htmlExtrator
				.execute(quantizedNews.getHtml());
		String pageType = extratorResults.get(BasicHtmlExtrator.KPAGETYPE);
		if (pageType != null) {
			quantizedNews.setIsTheme(pageType
					.equals(BasicHtmlExtrator.THEMEPAGE));
		}
		if (!quantizedNews.getIsTheme()) {
			return quantizedNews;
		}

		quantizedNews.setTitle(extratorResults.get(BasicHtmlExtrator.KTITLE));
		quantizedNews.setMainbody(extratorResults
				.get(BasicHtmlExtrator.KMAINBODY));
		quantizedNews.setImage(extratorResults.get(ImageHtmlExtrator.KIMAGE));

		return result;
	}
}

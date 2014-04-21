package com.talexu.htdais.service.html;

import java.util.Map;

public class CleanHtmlExtrator extends HtmlExtratorDecorator {

	public CleanHtmlExtrator() {
		super();
	}

	public CleanHtmlExtrator(HtmlExtrator htmlExtrator) {
		super(htmlExtrator);
	}

	@Override
	public Map<String, String> execute(String htmlText) {
		Map<String, String> result = super.execute(htmlText);
		result.remove(PreprocessHtmlExtrator.KPREPROCESSEDHTML);

		return result;
	}
}

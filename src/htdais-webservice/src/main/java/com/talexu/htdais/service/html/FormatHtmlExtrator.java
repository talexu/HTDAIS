package com.talexu.htdais.service.html;

import java.util.Map;

public class FormatHtmlExtrator extends HtmlExtratorDecorator {

	public FormatHtmlExtrator() {
		super();
	}

	public FormatHtmlExtrator(HtmlExtrator htmlExtrator) {
		super(htmlExtrator);
	}

	@Override
	public Map<String, String> execute(String htmlText) {
		Map<String, String> result = super.execute(htmlText);

		String mainBody = result.get(BasicHtmlExtrator.KMAINBODY);
		if (mainBody != null && mainBody != "") {
			result.put(BasicHtmlExtrator.KMAINBODY,
					mainBody.replaceAll("\\s+", "\n").trim());
		}

		return result;
	}
}

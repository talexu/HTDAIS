package com.talexu.htdais.service.html;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageHtmlExtrator extends HtmlExtratorDecorator {

	public final static String KIMAGE = "image";

	private Pattern imgSrcPattern = Pattern.compile(
			"<img[^>]+src=['\"](.*?\\.jpg)['\"]", Pattern.CASE_INSENSITIVE
					| Pattern.DOTALL);

	public ImageHtmlExtrator() {
		super();
	}

	public ImageHtmlExtrator(HtmlExtrator htmlExtrator) {
		super(htmlExtrator);
	}

	@Override
	public Map<String, String> execute(String htmlText) {
		Map<String, String> result = super.execute(htmlText);

		String preProcessedHtml = result
				.get(PreprocessHtmlExtrator.KPREPROCESSEDHTML);
		if (preProcessedHtml != null && preProcessedHtml != "") {
			String mainBodyWithImg = extractMainBody(preProcessedHtml
					.replaceAll("(?is)<(?!img\\s).*?>", ""));
			Matcher matcher = imgSrcPattern.matcher(mainBodyWithImg);
			if (matcher != null && matcher.find()) {
				result.put(KIMAGE, matcher.group(1).trim());
			}
		}

		return result;
	}
}

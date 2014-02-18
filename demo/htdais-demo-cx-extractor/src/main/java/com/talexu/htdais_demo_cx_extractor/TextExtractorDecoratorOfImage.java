package com.talexu.htdais_demo_cx_extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextExtractorDecoratorOfImage extends TextExtractorDecorator {

	private String _image = "";

	public String getImage() {
		return _image;
	}

	private Pattern imgSrcPattern = Pattern.compile(
			"<img[^>]+src=['\"](.*?\\.jpg)['\"]", Pattern.CASE_INSENSITIVE
					| Pattern.DOTALL);

	public TextExtractorDecoratorOfImage(TextExtractor textExtractor) {
		super(textExtractor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void extractHTML(String htmlText) {
		super.extractHTML(htmlText);

		String mainBodyWithImg = _textExtractor
				.extractMainBody(preProcess(htmlText));
		if (mainBodyWithImg != null) {
			Matcher matcher = imgSrcPattern.matcher(mainBodyWithImg);
			if (matcher != null && matcher.find()) {
				_image = matcher.group(1);
			}
		}
	}

	/**
	 * Pre processing.
	 * 
	 * @param htmlText
	 *            the html text
	 * 
	 * @return the string
	 */
	private String preProcess(String htmlText) {
		// DTD
		htmlText = htmlText.replaceAll("(?is)<!DOCTYPE.*?>", "");
		// html comment
		htmlText = htmlText.replaceAll("(?is)<!--.*?-->", "");
		// js
		htmlText = htmlText.replaceAll("(?is)<script.*?>.*?</script>", "");
		// css
		htmlText = htmlText.replaceAll("(?is)<style.*?>.*?</style>", "");
		// html
		htmlText = htmlText.replaceAll("(?is)<(?!img\\s).*?>", "");

		return _textExtractor.replaceSpecialChar(htmlText);
	}
}

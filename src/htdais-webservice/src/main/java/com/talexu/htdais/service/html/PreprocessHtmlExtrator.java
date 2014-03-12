package com.talexu.htdais.service.html;

import java.util.Map;

public class PreprocessHtmlExtrator extends HtmlExtratorDecorator {

	public final static String KPREPROCESSEDHTML = "preProcessHtml";

	public PreprocessHtmlExtrator() {
		super();
	}

	public PreprocessHtmlExtrator(HtmlExtrator htmlExtrator) {
		super(htmlExtrator);
	}

	@Override
	public Map<String, String> execute(String htmlText) {
		Map<String, String> result = super.execute(htmlText);
		result.put(KPREPROCESSEDHTML, preProcess(htmlText));
		return result;
	}

	/**
	 * Pre processing. 去除DTD, 注释, js, css, link以及特殊字符替换
	 * 
	 * @param htmlText
	 *            the html text
	 * 
	 * @return the string
	 */
	protected String preProcess(String htmlText) {
		// DTD
		htmlText = htmlText.replaceAll("(?is)<!DOCTYPE.*?>", "");
		// html comment
		htmlText = htmlText.replaceAll("(?is)<!--.*?-->", "");
		// js
		htmlText = htmlText.replaceAll("(?is)<script.*?>.*?</script>", "");
		// css
		htmlText = htmlText.replaceAll("(?is)<style.*?>.*?</style>", "");
		// link
		htmlText = htmlText.replaceAll("(?is)<a([^>]+)>(.+?)</a>", "");

		return replaceSpecialChar(htmlText);
	}
}

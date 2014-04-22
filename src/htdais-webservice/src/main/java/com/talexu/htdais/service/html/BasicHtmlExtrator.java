package com.talexu.htdais.service.html;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicHtmlExtrator extends HtmlExtratorDecorator {

	/**
	 * 结果字典集中的键
	 */
	public final static String KPAGETYPE = "pageType";
	public final static String KTITLE = "title";
	public final static String KMAINBODY = "mainBody";

	/**
	 * 页面类型
	 */
	public final static String THEMEPAGE = "themePage";
	public final static String UNKNOWNPAGE = "unknownPage";

	/** The Constant _titlePattern. */
	private final static String _titlePattern = "<title>(.*?)</title>";

	/** The Constant _titleRegexPattern. */
	private final static Pattern _titleRegexPattern = Pattern.compile(
			_titlePattern, Pattern.CANON_EQ | Pattern.DOTALL
					| Pattern.CASE_INSENSITIVE);

	public BasicHtmlExtrator() {
		super();
	}

	public BasicHtmlExtrator(HtmlExtrator htmlExtrator) {
		super(htmlExtrator);
	}

	@Override
	public Map<String, String> execute(String htmlText) {
		Map<String, String> result = super.execute(htmlText);

		result.put(KTITLE, extractTitle(htmlText));
		String preProcessedHtml = result
				.get(PreprocessHtmlExtrator.KPREPROCESSEDHTML);
		preProcessedHtml = preProcessedHtml.replaceAll("(?is)<.*?>", "");

		if (isContentPage(preProcessedHtml)) {
			String mainBody = extractMainBody(preProcessedHtml);
			result.put(KMAINBODY, mainBody);
			result.put(KPAGETYPE, mainBody == "" ? UNKNOWNPAGE : THEMEPAGE);
		} else {
			result.put(KPAGETYPE, UNKNOWNPAGE);
		}

		return result;
	}

	/**
	 * Checks if is content page.
	 * 
	 * @param htmlText
	 *            the html text
	 * 
	 * @return true, if is content page
	 */
	protected boolean isContentPage(String htmlText) {
		int count = 0;
		for (int i = 0; i < htmlText.length() && count < 5; i++) {
			if (htmlText.charAt(i) == '，' || htmlText.charAt(i) == '。')
				count++;
		}

		return count >= 5;
	}

	/**
	 * Extract title.
	 * 
	 * @param htmlText
	 *            the html text
	 */
	protected String extractTitle(String htmlText) {
		Matcher m1 = _titleRegexPattern.matcher(htmlText);
		if (m1.find()) {
			return replaceSpecialChar(m1.group(1)).replaceAll("\n+", "");
		}
		return null;
	}

}

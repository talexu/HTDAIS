package com.talexu.htdais.service.html;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class HtmlExtratorDecorator implements HtmlExtrator {

	/** 行块大小. */
	private static Integer _block = 3;

	/**
	 * Sets the block.
	 * 
	 * @param block
	 *            the new block
	 */
	@SuppressWarnings("unused")
	private static void setBlock(Integer block) {
		_block = block;
	}

	protected HtmlExtrator htmlExtrator;

	public HtmlExtrator getHtmlExtrator() {
		return htmlExtrator;
	}

	public void setHtmlExtrator(HtmlExtrator htmlExtrator) {
		this.htmlExtrator = htmlExtrator;
	}

	public HtmlExtratorDecorator() {

	}

	public HtmlExtratorDecorator(HtmlExtrator htmlExtrator) {
		this.htmlExtrator = htmlExtrator;
	}

	public Map<String, String> execute(String htmlText) {
		if (htmlExtrator != null) {
			return htmlExtrator.execute(htmlText);
		}
		return new HashMap<String, String>();
	}

	protected String extractMainBody(String htmlText) {
		List<String> lines = Arrays.asList(htmlText.split("\n"));
		List<Integer> indexDistribution = lineBlockDistribute(lines);

		List<String> textList = new ArrayList<String>();
		List<Integer> textBeginList = new ArrayList<Integer>();
		List<Integer> textEndList = new ArrayList<Integer>();

		for (int i = 0; i < indexDistribution.size(); i++) {
			if (indexDistribution.get(i) > 0) {
				StringBuilder tmp = new StringBuilder();
				textBeginList.add(i);
				while (i < indexDistribution.size()
						&& indexDistribution.get(i) > 0) {
					tmp.append(lines.get(i)).append("\n");
					i++;
				}
				textEndList.add(i);
				textList.add(tmp.toString());
			}
		}

		// 如果两块只差两个空行，并且两块包含文字均较多，则进行块合并，以弥补单纯抽取最大块的缺点
		for (int i = 1; i < textList.size(); i++) {
			if (textBeginList.get(i) == textEndList.get(i - 1) + 1
					&& textEndList.get(i) > textBeginList.get(i) + _block
					&& textList.get(i).replaceAll("\\s+", "").length() > 40) {
				if (textEndList.get(i - 1) == textBeginList.get(i - 1) + _block
						&& textList.get(i - 1).replaceAll("\\s+", "").length() < 40) {
					continue;
				}
				textList.set(i - 1, textList.get(i - 1) + textList.get(i));
				textEndList.set(i - 1, textEndList.get(i));

				textList.remove(i);
				textBeginList.remove(i);
				textEndList.remove(i);
				--i;
			}
		}

		String result = "";
		for (String text : textList) {
			// System.out.println("text:" + text + "\n" +
			// text.replaceAll("\\s+", "").length());
			if (text.replaceAll("\\s+", "").length() > result.replaceAll(
					"\\s+", "").length())
				result = text;
		}

		// 最长块长度小于100，归为非主题型网页
		if (result.replaceAll("\\s+", "").length() < 100)
			return "*推测您提供的网页为非主题型网页，目前暂不处理！:-)";
		else
			return result;
	}

	/**
	 * Line block distribute.
	 * 
	 * @param lines
	 *            the lines
	 * 
	 * @return the list< integer>
	 */
	protected List<Integer> lineBlockDistribute(List<String> lines) {
		List<Integer> indexDistribution = new ArrayList<Integer>();

		for (int i = 0; i < lines.size(); i++) {
			indexDistribution.add(lines.get(i).replaceAll("\\s+", "").length());
		}
		// 删除上下存在两个空行的文字行
		for (int i = 0; i + 4 < lines.size(); i++) {
			if (indexDistribution.get(i) == 0
					&& indexDistribution.get(i + 1) == 0
					&& indexDistribution.get(i + 2) > 0
					&& indexDistribution.get(i + 2) < 40
					&& indexDistribution.get(i + 3) == 0
					&& indexDistribution.get(i + 4) == 0) {
				// System.out.println("line:" + lines.get(i+2));
				lines.set(i + 2, "");
				indexDistribution.set(i + 2, 0);
				i += 3;
			}
		}

		for (int i = 0; i < lines.size() - _block; i++) {
			int wordsNum = indexDistribution.get(i);
			for (int j = i + 1; j < i + _block && j < lines.size(); j++) {
				wordsNum += indexDistribution.get(j);
			}
			indexDistribution.set(i, wordsNum);
		}

		return indexDistribution;
	}

	/**
	 * Replace special char.
	 * 
	 * @param content
	 *            the content
	 * 
	 * @return the string
	 */
	protected String replaceSpecialChar(String content) {
		String text = content.replaceAll("&quot;", "\"");
		text = text.replaceAll("&ldquo;", "“");
		text = text.replaceAll("&rdquo;", "”");
		text = text.replaceAll("&middot;", "·");
		text = text.replaceAll("&#8231;", "·");
		text = text.replaceAll("&#8212;", "——");
		text = text.replaceAll("&#28635;", "濛");
		text = text.replaceAll("&hellip;", "…");
		text = text.replaceAll("&#23301;", "嬅");
		text = text.replaceAll("&#27043;", "榣");
		text = text.replaceAll("&#8226;", "·");
		text = text.replaceAll("&#40;", "(");
		text = text.replaceAll("&#41;", ")");
		text = text.replaceAll("&#183;", "·");
		text = text.replaceAll("&amp;", "&");
		text = text.replaceAll("&bull;", "·");
		text = text.replaceAll("&lt;", "<");
		text = text.replaceAll("&#60;", "<");
		text = text.replaceAll("&gt;", ">");
		text = text.replaceAll("&#62;", ">");
		text = text.replaceAll("&nbsp;", " ");
		text = text.replaceAll("&#160;", " ");
		text = text.replaceAll("&tilde;", "~");
		text = text.replaceAll("&mdash;", "—");
		text = text.replaceAll("&copy;", "@");
		text = text.replaceAll("&#169;", "@");
		text = text.replaceAll("♂", "");
		text = text.replaceAll("\r\n|\r", "\n");

		return text;
	}
}

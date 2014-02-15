package com.talexu.htdais_demo_cx_extractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>
 * 在线性时间内抽取主题类（新闻、博客等）网页的正文。 采用了<b>基于行块分布函数</b>的方法，为保持通用性没有针对特定网站编写规则。
 * </p>
 * 
 * @author Chen Xin(xchen@ir.hit.edu.cn) Created on 2009-1-11 Updated on
 *         2010-08-09
 */
public class TextExtract {

	private List<String> lines;
	private final static int blocksWidth = 3;
	private int threshold;
	private String html;
	private boolean flag;
	private int start;
	private int end;
	private StringBuilder text;
	private ArrayList<Integer> indexDistribution;

	public TextExtract() {
		lines = new ArrayList<String>();
		indexDistribution = new ArrayList<Integer>();
		text = new StringBuilder();
		flag = false;
		/* 当待抽取的网页正文中遇到成块的新闻标题未剔除时，只要增大此阈值即可。 */
		/* 阈值增大，准确率提升，召回率下降；值变小，噪声会大，但可以保证抽到只有一句话的正文 */
		threshold = -1;
	}

	/**
	 * 抽取网页正文，不判断该网页是否是目录型。即已知传入的肯定是可以抽取正文的主题类网页。
	 * 
	 * @param _html
	 *            网页HTML字符串
	 * 
	 * @return 网页正文string
	 */
	public String parse(String _html) {
		return parse(_html, false);
	}

	/**
	 * 判断传入HTML，若是主题类网页，则抽取正文；否则输出<b>"unkown"</b>。
	 * 
	 * @param _html
	 *            网页HTML字符串
	 * @param _flag
	 *            true进行主题类判断, 省略此参数则默认为false
	 * 
	 * @return 网页正文string
	 */
	public String parse(String _html, boolean _flag) {
		flag = _flag;
		html = _html;
		html = preProcess(html);
		// System.out.println(html);
		return getText();
	}

	private static Pattern doctypePattern = Pattern.compile("<!DOCTYPE.*?>",
			Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern commentPattern = Pattern.compile("<!--.*?-->",
			Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern jsPattern = Pattern.compile(
			"<script.*?>.*?</script>", Pattern.CASE_INSENSITIVE
					| Pattern.DOTALL);
	private static Pattern cssPattern = Pattern.compile(
			"<style.*?>.*?</style>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern specialCharPattern = Pattern.compile(
			"&.{2,5};|&#.{2,5};", Pattern.CASE_INSENSITIVE);
	private static Pattern spanBeginPattern = Pattern.compile("<span.*?>",
			Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern spanEndPattern = Pattern.compile("</span>",
			Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern link = Pattern.compile("<a([^>]+)>(.+?)</a>",
			Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	// private static Pattern angleBracketsPattern = Pattern.compile(
	// "<(?!img\\s).*?>", Pattern.CASE_INSENSITIVE);
	private static Pattern angleBracketsWithoutImgPattern = Pattern.compile(
			"<(?!img\\s).*?>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern angleBracketsPattern = Pattern.compile("<.*?>",
			Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static Pattern brPattern = Pattern.compile("\r\n",
			Pattern.CASE_INSENSITIVE);
	private static Pattern spacesPattern = Pattern.compile("\\s+",
			Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

	public static String remainImgAndMainBody(String source) {
		source = doctypePattern.matcher(source).replaceAll("");
		source = commentPattern.matcher(source).replaceAll("");
		source = jsPattern.matcher(source).replaceAll("");
		source = cssPattern.matcher(source).replaceAll("");
		source = specialCharPattern.matcher(source).replaceAll(" ");
		// 剔除连续成片的超链接文本（认为是，广告或噪音）,超链接多藏于span中
		source = spanBeginPattern.matcher(source).replaceAll("");
		source = spanEndPattern.matcher(source).replaceAll("");

		int len = source.length();
		while ((source = link.matcher(source).replaceAll("")).length() != len) {
			len = source.length();
		}

		// 防止html中在<>中包括大于号的判断
		source = angleBracketsWithoutImgPattern.matcher(source).replaceAll("");
		source = spacesPattern.matcher(source).replaceAll(
				System.getProperty("line.separator"));

		return source;

	}

	private static String preProcess(String source) {
		source = doctypePattern.matcher(source).replaceAll("");

		source = commentPattern.matcher(source).replaceAll("");

		source = jsPattern.matcher(source).replaceAll("");

		source = cssPattern.matcher(source).replaceAll("");

		source = specialCharPattern.matcher(source).replaceAll(" ");

		// 剔除连续成片的超链接文本（认为是，广告或噪音）,超链接多藏于span中
		source = spanBeginPattern.matcher(source).replaceAll("");
		source = spanEndPattern.matcher(source).replaceAll("");

		int len = source.length();
		while ((source = link.matcher(source).replaceAll("")).length() != len) {
			len = source.length();
		}

		// 防止html中在<>中包括大于号的判断
		source = angleBracketsPattern.matcher(source).replaceAll("");

		source = brPattern.matcher(source).replaceAll(
				System.getProperty("line.separator"));

		return source;

	}

	private String getText() {
		lines = Arrays.asList(html.split(System.getProperty("line.separator")));
		indexDistribution.clear();

		int empty = 0;// 空行的数量
		for (int i = 0; i < lines.size() - blocksWidth; i++) {

			if (lines.get(i).length() == 0) {
				empty++;
			}

			int wordsNum = 0;
			for (int j = i; j < i + blocksWidth; j++) {
				lines.set(j, lines.get(j).replaceAll("\\s+", ""));
				wordsNum += lines.get(j).length();
			}
			indexDistribution.add(wordsNum);
			// System.out.println(wordsNum);
		}
		int sum = 0;

		for (int i = 0; i < indexDistribution.size(); i++) {
			sum += indexDistribution.get(i);
		}

		threshold = Math.min(100, (sum / indexDistribution.size()) << (empty
				/ (lines.size() - empty) >>> 1));
		threshold = Math.max(50, threshold);

		start = -1;
		end = -1;
		boolean boolstart = false, boolend = false;
		boolean firstMatch = true;// 前面的标题块往往比较小，应该减小与它匹配的阈值
		text.setLength(0);

		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < indexDistribution.size() - 1; i++) {

			if (firstMatch && !boolstart) {
				if (indexDistribution.get(i) > (threshold / 2) && !boolstart) {
					if (indexDistribution.get(i + 1).intValue() != 0
							|| indexDistribution.get(i + 2).intValue() != 0) {
						firstMatch = false;
						boolstart = true;
						start = i;
						continue;
					}
				}

			}
			if (indexDistribution.get(i) > threshold && !boolstart) {
				if (indexDistribution.get(i + 1).intValue() != 0
						|| indexDistribution.get(i + 2).intValue() != 0
						|| indexDistribution.get(i + 3).intValue() != 0) {
					boolstart = true;
					start = i;
					continue;
				}
			}
			if (boolstart) {
				if (indexDistribution.get(i).intValue() == 0
						|| indexDistribution.get(i + 1).intValue() == 0) {
					end = i;
					boolend = true;
				}
			}

			if (boolend) {
				buffer.setLength(0);
				// System.out.println(start+1 + "\t\t" + end+1);
				for (int ii = start; ii <= end; ii++) {
					if (lines.get(ii).length() < 5)
						continue;
					buffer.append(lines.get(ii)
							+ System.getProperty("line.separator"));
				}
				String str = buffer.toString();
				// System.out.println(str);
				if (str.contains("Copyright") || str.contains("版权所有"))
					continue;
				text.append(str);
				boolstart = boolend = false;
			}
		}

		if (start > end) {
			buffer.setLength(0);
			int size_1 = lines.size() - 1;
			for (int ii = start; ii <= size_1; ii++) {
				if (lines.get(ii).length() < 5)
					continue;
				buffer.append(lines.get(ii)
						+ System.getProperty("line.separator"));
			}
			String str = buffer.toString();
			// System.out.println(str);
			if ((!str.contains("Copyright")) || (!str.contains("版权所有"))) {
				text.append(str);
			}
		}

		return text.toString();
	}

	public static void main(String[] args) {
		System.out.println("===============");
		String s = "<img  class='fit-image' onload='javascript:if(this.width>498)this.width=498;' />hello";
		// source = source.replaceAll("<[^'\"]*['\"].*['\"].*?>", "");
		System.out.println(TextExtract.preProcess(s));
	}
}
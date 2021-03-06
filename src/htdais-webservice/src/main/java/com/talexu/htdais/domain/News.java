package com.talexu.htdais.domain;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public abstract class News {

	private String uri;
	private String html;
	private Calendar calendar;
	private String title;
	private Boolean isTheme;
	private String summary;
	private String mainbody;
	private String image;
	private List<String> keywords;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsTheme() {
		return isTheme;
	}

	public void setIsTheme(Boolean isTheme) {
		this.isTheme = isTheme;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getMainbody() {
		return mainbody;
	}

	public void setMainbody(String mainbody) {
		this.mainbody = mainbody;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public News() {
		isTheme = false;
		keywords = new LinkedList<>();
	}

	public static List<News> getNews(List<QuantizedNews> quantizedNews) {
		List<News> news = new LinkedList<>();
		for (QuantizedNews quantizedNew : quantizedNews) {
			news.add(quantizedNew);
		}

		return news;
	}
}

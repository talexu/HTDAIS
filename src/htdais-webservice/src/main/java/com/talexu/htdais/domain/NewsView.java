package com.talexu.htdais.domain;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class NewsView {
	private String uri;
	private Calendar calendar;
	private String title;
	private String summary;
	private String mainbody;
	private String image;
	private List<String> keywords;
	private double ranking;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
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

	public double getRanking() {
		return ranking;
	}

	public void setRanking(double ranking) {
		this.ranking = ranking;
	}

	public NewsView() {

	}

	public NewsView(QuantizedNews quantizedNews) {
		setUri(quantizedNews.getUri());
		setCalendar(quantizedNews.getCalendar());
		setTitle(quantizedNews.getTitle());
		setSummary(quantizedNews.getSummary());
		setMainbody(quantizedNews.getMainbody());
		setImage(quantizedNews.getImage());
		setKeywords(quantizedNews.getKeywords());
		setRanking(quantizedNews.getRanking());
	}

	public static List<NewsView> getNewsViews(List<QuantizedNews> quantizedNews) {
		List<NewsView> newsViews = new LinkedList<>();
		for (QuantizedNews quantizedNew : quantizedNews) {
			newsViews.add(new NewsView(quantizedNew));
		}

		return newsViews;
	}
}

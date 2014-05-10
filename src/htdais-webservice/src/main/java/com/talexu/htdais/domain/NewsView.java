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
	
	public static List<NewsView> getTestNewsViews(){
		List<NewsView> newsViews = new LinkedList<>();
		for (int i = 0; i < 20; i++) {
			NewsView addedNewsView = new NewsView();
			addedNewsView.setUri("http://www.baidu.com");
			addedNewsView.setCalendar(Calendar.getInstance());
			addedNewsView.setImage("http://img1.gtimg.com/news/pics/hv1/246/201/1590/103441251.png");
			addedNewsView.setRanking(0.5);
			addedNewsView.setTitle("Title" + i);
			addedNewsView.setSummary("Summary" + i);
			addedNewsView.setMainbody("Mainbody" + i);
			newsViews.add(addedNewsView);
		}
		
		return newsViews;
	}
	
	public static List<QuantizedNews> getTestQuantizedNews(){
		List<QuantizedNews> quantizedNews = new LinkedList<>();
		for (int i = 0; i < 20; i++) {
			QuantizedNews addedNewsView = new QuantizedNews();
			addedNewsView.setUri("http://www.baidu.com");
			addedNewsView.setCalendar(Calendar.getInstance());
			addedNewsView.setImage("http://img1.gtimg.com/news/pics/hv1/246/201/1590/103441251.png");
			addedNewsView.setRanking(0.5);
			addedNewsView.setTitle("Title" + i);
			addedNewsView.setSummary("Summary" + i);
			addedNewsView.setMainbody("Mainbody" + i);
			quantizedNews.add(addedNewsView);
		}
		
		return quantizedNews;
	}
}

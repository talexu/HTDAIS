package com.talexu.htdais.model;

import java.util.LinkedList;
import java.util.List;

import com.talexu.htdais.domain.News;
import com.talexu.htdais.domain.QuantizedNews;

public class ContentPool {

	private List<QuantizedNews> news;
	private List<News> hotNews;
	private List<News> todayNews;

	public List<QuantizedNews> getNews() {
		return news;
	}

	public void setNews(List<QuantizedNews> news) {
		this.news = news;
	}

	public List<News> getHotNews() {
		return hotNews;
	}

	public void setHotNews(List<News> hotNews) {
		this.hotNews = hotNews;
	}

	public List<News> getTodayNews() {
		return todayNews;
	}

	public void setTodayNews(List<News> todayNews) {
		this.todayNews = todayNews;
	}

	public ContentPool() {
		news = new LinkedList<QuantizedNews>();
		hotNews = new LinkedList<News>();
		todayNews = new LinkedList<News>();
	}
}

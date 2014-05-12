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
	
	public static List<NewsView> getTestCarousel(){
		List<NewsView> newsViews = new LinkedList<>();
		
		NewsView addedNewsView = new NewsView();
		addedNewsView.setUri("news.163.com/14/0510/22/9RTRK5M200014JB5.html");
		addedNewsView.setCalendar(Calendar.getInstance());
		addedNewsView.setImage("http://img1.cache.netease.com/catchpic/7/78/78D94C231C10C04753C997F546BAAFE9.jpg");
		addedNewsView.setRanking(0.5);
		addedNewsView.setTitle("习近平：老老实实干事 清清白白为官_网易新闻中心");
		newsViews.add(addedNewsView);
		
		addedNewsView = new NewsView();
		addedNewsView.setUri("news.163.com/14/0511/15/9RVNJG470001124J.html");
		addedNewsView.setCalendar(Calendar.getInstance());
		addedNewsView.setImage("http://img3.cache.netease.com/photo/0001/2014-05-11/600x450_9RVP6ANI00AN0001.jpg");
		addedNewsView.setRanking(0.5);
		addedNewsView.setTitle("深圳降2008年来最强暴雨 大范围严重积涝_网易新闻中心");
		newsViews.add(addedNewsView);
		
		addedNewsView = new NewsView();
		addedNewsView.setUri("news.163.com/14/0511/08/9RUVV43300014JB6.html#p=9RVS3UIN00AO0001");
		addedNewsView.setCalendar(Calendar.getInstance());
		addedNewsView.setImage("http://img3.cache.netease.com/photo/0001/2014-05-11/600x450_9RVS3UIN00AO0001.jpg");
		addedNewsView.setRanking(0.5);
		addedNewsView.setTitle("乌克兰东部两州今日公投 或建新俄罗斯_网易新闻中心");
		newsViews.add(addedNewsView);
		
		addedNewsView = new NewsView();
		addedNewsView.setUri("news.163.com/14/0511/18/9S01QB4800014JB5.html");
		addedNewsView.setCalendar(Calendar.getInstance());
		addedNewsView.setImage("http://img3.cache.netease.com/photo/0001/2014-05-10/600x450_9RSBLCAG00AO0001.jpg");
		addedNewsView.setRanking(0.5);
		addedNewsView.setTitle("菲方寻海南方言翻译审中国渔民 最高或判刑20年_网易新闻中心");
		newsViews.add(addedNewsView);
		
		addedNewsView = new NewsView();
		addedNewsView.setUri("news.163.com/14/0511/11/9RVAHF5E0001124J.html");
		addedNewsView.setCalendar(Calendar.getInstance());
		addedNewsView.setImage("http://img4.cache.netease.com/photo/0001/2014-05-11/600x450_9RVHHEPK00AN0001.jpg");
		addedNewsView.setRanking(0.5);
		addedNewsView.setTitle("青岛一工厂挡土墙因暴雨倒塌 18人遇难(图)_网易新闻中心");
		newsViews.add(addedNewsView);
		
		return newsViews;
	}
}

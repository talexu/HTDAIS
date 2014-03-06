package com.talexu.htdais.domain;

import java.util.Date;
import java.util.List;

public abstract class News {
	
	private String uri;
	private Date date;
	private String header;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
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

	}
}

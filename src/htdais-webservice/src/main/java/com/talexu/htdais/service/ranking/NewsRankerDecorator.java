package com.talexu.htdais.service.ranking;

import java.util.List;

import com.talexu.htdais.domain.QuantizedNews;

public abstract class NewsRankerDecorator implements NewsRanker {

	protected NewsRanker newsRanker;

	public NewsRanker getNewsRanker() {
		return newsRanker;
	}

	public void setNewsRanker(NewsRanker newsRanker) {
		this.newsRanker = newsRanker;
	}

	public NewsRankerDecorator() {

	}

	public NewsRankerDecorator(NewsRanker newsRanker) {
		this.newsRanker = newsRanker;
	}

	public List<QuantizedNews> execute(List<QuantizedNews> quantizedNews) {
		if (newsRanker != null) {
			return newsRanker.execute(quantizedNews);
		}
		return quantizedNews;
	}

}

package com.talexu.htdais.service.ranking;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.talexu.htdais.domain.QuantizedNews;

public class NewsThemeFilter extends NewsRankerDecorator {

	Logger logger = LoggerFactory.getLogger(NewsThemeFilter.class);

	public NewsThemeFilter() {
		super();
	}

	public NewsThemeFilter(NewsRanker newsRanker) {
		super(newsRanker);
	}

	@Override
	public List<QuantizedNews> execute(List<QuantizedNews> quantizedNews) {
		List<QuantizedNews> filteredNews = new LinkedList<>();
		for (QuantizedNews quantizedNew : super.execute(quantizedNews)) {
			if (quantizedNew.getIsTheme()) {
				filteredNews.add(quantizedNew);
			}
		}

		return filteredNews;
	}
}

package com.talexu.htdais.service.ranking;

import java.util.List;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.model.ContentPool;

public class StoreRanker extends ClusterNewsRanker {

	ContentPool contentPool;

	public ContentPool getContentPool() {
		return contentPool;
	}

	public void setContentPool(ContentPool contentPool) {
		this.contentPool = contentPool;
	}

	@Override
	public List<QuantizedNews> rankNews(List<QuantizedNews> quantizedNews) {
		List<QuantizedNews> rankedNews = super.rankNews(quantizedNews);
		return null;
	}
}

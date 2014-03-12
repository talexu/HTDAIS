package com.talexu.htdais.service.ranking;

import java.util.List;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.model.ContentPool;

public class StoreRanker extends NewsRankerDecorator {

	private ContentPool contentPool;

	public ContentPool getContentPool() {
		return contentPool;
	}

	public void setContentPool(ContentPool contentPool) {
		this.contentPool = contentPool;
	}

	public StoreRanker() {
		super();
	}

	public StoreRanker(NewsRanker newsRanker) {
		super(newsRanker);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<QuantizedNews> execute(List<QuantizedNews> quantizedNews) {
		return super.execute(quantizedNews);
	}
}

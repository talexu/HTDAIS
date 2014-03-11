package com.talexu.htdais.service.ranking;

import java.util.List;

import com.talexu.htdais.domain.QuantizedNews;

public interface NewsRanker {

	public List<QuantizedNews> rankNews(List<QuantizedNews> quantizedNews);
}

package com.talexu.htdais.service.ranking;

import java.util.List;

import com.talexu.htdais.domain.QuantizedNews;

public abstract class NormalNewsRanker implements NewsRanker {

	/**
	 * 设置排序参数（所属簇）
	 * @param quantizedNews
	 * @return
	 */
	protected abstract List<QuantizedNews> initRankingPrameters(
			List<QuantizedNews> quantizedNews);

	@Override
	public List<QuantizedNews> rankNews(List<QuantizedNews> quantizedNews) {
		// TODO Auto-generated method stub
		List<QuantizedNews> quantizedNewsWithRankingParameters = initRankingPrameters(quantizedNews);
		return null;
	}

}

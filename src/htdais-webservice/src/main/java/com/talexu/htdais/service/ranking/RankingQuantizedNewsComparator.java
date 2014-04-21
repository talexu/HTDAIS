package com.talexu.htdais.service.ranking;

import java.util.Comparator;

import com.talexu.htdais.domain.QuantizedNews;

public class RankingQuantizedNewsComparator implements
		Comparator<QuantizedNews> {

	@Override
	public int compare(QuantizedNews o1, QuantizedNews o2) {
		if (o1 != null && o2 != null) {
			return (new Double(o1.getRanking() - o2.getRanking())).intValue();
		}
		if (o1 != null && o2 == null) {
			return 1;
		}
		if (o1 == null && o2 != null) {
			return -1;
		}
		return 0;
	}

}

package com.talexu.htdais.service.ranking;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.talexu.htdais.domain.QuantizedNews;

public class CarouselNewsRanker extends NewsRankerDecorator {

	Logger logger = LoggerFactory.getLogger(CarouselNewsRanker.class);

	private Pattern imgSrcPattern = Pattern.compile(
			"^http.*?.jpg$", Pattern.CASE_INSENSITIVE
					| Pattern.DOTALL);

	int carouselCount = 5;

	public int getCarouselCount() {
		return carouselCount;
	}

	public void setCarouselCount(int carouselCount) {
		this.carouselCount = carouselCount;
	}

	public CarouselNewsRanker() {
		super();
	}

	public CarouselNewsRanker(NewsRanker newsRanker) {
		super(newsRanker);
	}

	@Override
	public List<QuantizedNews> execute(List<QuantizedNews> quantizedNews) {
		List<QuantizedNews> carouselNews = new LinkedList<QuantizedNews>();
		int count = 0;
		for (QuantizedNews quantizedNew : quantizedNews) {
			if (quantizedNew.getImage() != null) {
				Matcher matcher = imgSrcPattern.matcher(quantizedNew.getImage());
				if (matcher != null && matcher.find()) {
					carouselNews.add(quantizedNew);
					if (++count >= carouselCount) {
						break;
					}
				}
			}
		}

		return carouselNews;
	}
}

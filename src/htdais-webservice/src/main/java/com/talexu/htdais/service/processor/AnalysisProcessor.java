package com.talexu.htdais.service.processor;

import java.io.IOException;
import java.util.Collection;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.lucene4.AnsjAnalysis;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.WeightedSpanTerm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.talexu.htdais.domain.QuantizedNews;

public class AnalysisProcessor extends NewsProcessorDecorator {

	Logger logger = LoggerFactory.getLogger(AnalysisProcessor.class);

	KeyWordComputer kwc;
	Analyzer analyzer;

	public AnalysisProcessor() {
		super();
		initAnalyzer();
	}

	public AnalysisProcessor(NewsProcessor newsProcessor) {
		super(newsProcessor);
		initAnalyzer();
	}

	protected void initAnalyzer() {
		kwc = new KeyWordComputer(5);
		analyzer = new AnsjAnalysis(true);
	}

	@Override
	public QuantizedNews execute(QuantizedNews quantizedNews) {
		QuantizedNews result = super.execute(quantizedNews);

		if (result != null) {
			// Keywords
			Collection<Keyword> keywords = kwc.computeArticleTfidf(
					result.getTitle(), result.getMainbody());
			for (Keyword keyword : keywords) {
				result.getKeywords().add(keyword.getName());
			}

			// Summary
			WeightedSpanTerm[] weightedSpanTerms = new WeightedSpanTerm[keywords
					.size()];
			int i = 0;
			for (Keyword keyword : keywords) {
				weightedSpanTerms[i++] = new WeightedSpanTerm(1,
						keyword.getName());
			}
			QueryScorer scorer = new QueryScorer(weightedSpanTerms);
			Highlighter highlighter = new Highlighter(new SimpleHTMLFormatter(
					"", ""), scorer);
			highlighter.setTextFragmenter(new SimpleFragmenter(200));
			try {
				result.setSummary(highlighter.getBestFragment(analyzer,
						"myfield", result.getMainbody()));
			} catch (IOException | InvalidTokenOffsetsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
}
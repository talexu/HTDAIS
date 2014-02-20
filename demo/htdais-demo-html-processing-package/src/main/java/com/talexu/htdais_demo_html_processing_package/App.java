package com.talexu.htdais_demo_html_processing_package;

import java.io.IOException;
import java.util.Collection;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.lucene4.AnsjAnalysis;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.WeightedSpanTerm;

/**
 * Hello world!
 * 
 */
public class App {
	static TextExtractorDecoratorOfImage te = new TextExtractorDecoratorOfImage(
			new TextExtractorDecoratorFormat(new TextExtractor()));

	public static void main(String[] args) {

//		testNew("http://news.163.com/14/0214/02/9L0SL2S300014AEE.html#f=dfocus");
		testNew("http://news.163.com/14/0215/04/9L3KAECP0001124J.html");
		testNew("http://news.163.com/14/0215/13/9L4JH42I0001124J.html");
		testNew("http://news.163.com/14/0215/20/9L5C8JR100014JB6.html");
		testNew("http://world.163.com/14/0215/08/9L433CJ80001121M.html");
	}

	private static void testNew(String uri) {
		System.out.println(uri);
		te.extractURL(uri);
		String title = te.getTitle();
		String mainBody = te.getText();

		System.out.println("标题: " + te.getTitle());
		System.out.println("----------正文----------");
		System.out.println(mainBody);

		KeyWordComputer kwc = new KeyWordComputer(5);
		Collection<Keyword> keywords = kwc.computeArticleTfidf(title, mainBody);
		System.out.println("----------关键词----------");
		for (Keyword keyword : keywords) {
			System.out.print(keyword + ", ");
		}
		System.out.println();

		System.out.println("----------摘要----------");
		WeightedSpanTerm[] weightedSpanTerms = new WeightedSpanTerm[keywords
				.size()];
		int i = 0;
		for (Keyword keyword : keywords) {
			weightedSpanTerms[i++] = new WeightedSpanTerm(1, keyword.getName());
		}
		QueryScorer scorer = new QueryScorer(weightedSpanTerms);
		Highlighter highlighter = new Highlighter(new SimpleHTMLFormatter("",
				""), scorer);
		highlighter.setTextFragmenter(new SimpleFragmenter(200));

		Analyzer analyzer = new AnsjAnalysis(true);
		try {
			System.out.println(highlighter.getBestFragment(analyzer, "myfield",
					mainBody));
		} catch (IOException | InvalidTokenOffsetsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("----------图片----------");
		System.out.println(te.getImage());
	}
}

package com.talexu.htdais.service.processor;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.html.BasicHtmlExtrator;
import com.talexu.htdais.service.html.FormatHtmlExtrator;
import com.talexu.htdais.service.html.ImageHtmlExtrator;
import com.talexu.htdais.service.html.PreprocessHtmlExtrator;

public class TestAnalysisProcessor {

	NewsProcessor newsProcessor;

	String url = "http://news.163.com/14/0311/19/9N3290D500014JB6.html";
	String html;
	QuantizedNews quantizedNews;

	String url2 = "http://news.163.com/14/0314/07/9N9GKIBP0001124J.html";
	String html2;
	QuantizedNews quantizedNews2;

	@Before
	public void setUp() throws Exception {
		HtmlProcessor htmlProcessor = new HtmlProcessor();
		htmlProcessor.setHtmlExtrator(new FormatHtmlExtrator(
				new ImageHtmlExtrator(new BasicHtmlExtrator(
						new PreprocessHtmlExtrator()))));
		newsProcessor = new AnalysisProcessor(htmlProcessor);

		InputStream in = null;

		try {
			in = new URL(url).openStream();
			html = IOUtils.toString(in, "GB18030");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
		}
		quantizedNews = new QuantizedNews();
		quantizedNews.setUri(url);
		quantizedNews.setHtml(html);

		try {
			in = new URL(url2).openStream();
			html2 = IOUtils.toString(in, "GB18030");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
		}
		quantizedNews2 = new QuantizedNews();
		quantizedNews2.setUri(url2);
		quantizedNews2.setHtml(html2);
	}

	@Test
	public void testExecute() {
		assertTrue(newsProcessor.execute(quantizedNews) instanceof QuantizedNews);
		assertTrue(newsProcessor.execute(quantizedNews2) instanceof QuantizedNews);
	}

}
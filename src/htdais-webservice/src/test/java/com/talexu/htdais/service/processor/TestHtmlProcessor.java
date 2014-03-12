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

public class TestHtmlProcessor {

	HtmlProcessor htmlProcessor;
	String url = "http://news.163.com/14/0311/19/9N3290D500014JB6.html";
	String html;
	QuantizedNews quantizedNews;

	@Before
	public void setUp() throws Exception {
		htmlProcessor = new HtmlProcessor();
		htmlProcessor.setHtmlExtrator(new FormatHtmlExtrator(
				new ImageHtmlExtrator(new BasicHtmlExtrator(
						new PreprocessHtmlExtrator()))));

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
	}

	@Test
	public void testExecute() {
		assertTrue(htmlProcessor instanceof HtmlProcessor);
		QuantizedNews result = htmlProcessor.execute(quantizedNews);
		System.out.println(result.getUri());
		System.out.println(result.getIsTheme());
		System.out.println(result.getTitle());
		System.out.println(result.getMainbody());
		System.out.println(result.getImage());
	}

}

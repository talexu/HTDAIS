package com.talexu.htdais.service.html;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestHtmlExtrator {
	
	Logger logger = LoggerFactory.getLogger(TestHtmlExtrator.class);
	
	HtmlExtrator htmlExtrator;
	String html;

	@Before
	public void setUp() throws Exception {
		htmlExtrator = new FormatHtmlExtrator(new ImageHtmlExtrator(
				new BasicHtmlExtrator(new PreprocessHtmlExtrator())));

		// File file = new File(
		// "/Users/bjutales/Downloads/习近平：任何情况下决不牺牲国家核心利益_网易新闻中心.html");
		// try {
		// html = FileUtils.readFileToString(file, "GB18030");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		InputStream in = null;
		try {
			in = new URL("http://news.163.com/14/0311/19/9N3290D500014JB6.html")
					.openStream();
			html = IOUtils.toString(in, "GB18030");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
		}
	}

	@Test
	public void testExecute() {
		assertTrue(htmlExtrator instanceof HtmlExtrator);
		Map<String, String> result = htmlExtrator.execute(html);
		result.remove(PreprocessHtmlExtrator.KPREPROCESSEDHTML);
		assertTrue(result instanceof Map);
	}

}

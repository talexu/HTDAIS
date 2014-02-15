package com.talexu.htdais_demo_html_processing_package;

import java.io.IOException;

import junit.framework.TestCase;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TextExtractTest extends TestCase {

	TextExtract textExtract = new TextExtract();
	String html = "";

	protected void setUp() throws Exception {
		super.setUp();

		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet(
					"http://news.163.com/14/0214/02/9L0SL2S300014AEE.html#f=dfocus");
			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse response)
						throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity)
								: null;
					} else {
						throw new ClientProtocolException(
								"Unexpected response status: " + status);
					}
				}

			};
			html = httpclient.execute(httpget, responseHandler);
		} finally {
			httpclient.close();
		}
	}

	public void testTextExtract() {
		// fail("Not yet implemented");
	}

	public void testParseString() {
		System.out.println("----------Parse----------");
		System.out.println(textExtract.parse(html));
	}

	public void testParseStringBoolean() {
		// fail("Not yet implemented");
	}

	public void testGetTitle() {
		assertEquals("河南上访训诫中心探访:七旬老妪睡水泥地上_网易新闻中心", textExtract.getTitle(html));
	}

	public void testGetImgSrc() {
		assertEquals(
				"http://img1.cache.netease.com/catchpic/B/B3/B30DD8AD45A182FE67A10FB119A4BECD.jpg",
				textExtract
						.getImgSrc("<img alt=\"河南排查清理上访训诫中心\" src=\"http://img1.cache.netease.com/catchpic/B/B3/B30DD8AD45A182FE67A10FB119A4BECD.jpg\"/>"));

		assertEquals(
				"http://img1.cache.netease.com/catchpic/B/B3/B30DD8AD45A182FE67A10FB119A4BECD.jpg",
				textExtract
						.getImgSrc("<IMG alt=\"河南排查清理上访训诫中心\" src='http://img1.cache.netease.com/catchpic/B/B3/B30DD8AD45A182FE67A10FB119A4BECD.jpg'/>"));

		assertEquals(
				"http://img1.cache.netease.com/catchpic/B/B3/B30DD8AD45A182FE67A10FB119A4BECD.jpg",
				textExtract
						.getImgSrc("<img\\nsrc=\"http://img1.cache.netease.com/catchpic/B/B3/B30DD8AD45A182FE67A10FB119A4BECD.jpg\"/>"));
		
		assertEquals(
				"http://img1.cache.netease.com/catchpic/B/B3/B30DD8AD45A182FE67A10FB119A4BECD.jpg",
				textExtract
						.getImgSrc("<img alt=\"河南排查清理上访训诫中心\" src=\"http://img1.cache.netease.com/catchpic/B/B3/B30DD8AD45A182FE67A10FB119A4BECD.jpg\"><123"));
		
		assertEquals(
				"http://img1.cache.netease.com/catchpic/B/B3/B30DD8AD45A182FE67A10FB119A4BECD.jpg",
				textExtract
						.getImgSrc("<img alt=\"河南排查清理上访训诫中心\" src=\"http://img1.cache.netease.com/catchpic/B/B3/B30DD8AD45A182FE67A10FB119A4BECD.jpg\" width=\"1\" height=\"1\"/>"));
		
		assertEquals(
				null,
				textExtract
						.getImgSrc("<imgsrc=\"http://img1.cache.netease.com/catchpic/B/B3/B30DD8AD45A182FE67A10FB119A4BECD.jpg\"/>"));
	}

	public void testGetImgAndText() {
		System.out.println("----------GetImgAndText----------");
		System.out.println(textExtract.getImgAndText(html));
	}

}

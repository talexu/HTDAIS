package com.talexu.htdais_demo_cx_extractor;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws ClientProtocolException,
			IOException {

		 TextExtractorDecoratorOfImage te = new TextExtractorDecoratorOfImage(
		 new TextExtractorDecoratorFormat(new TextExtractor()));
//		TextExtractorDecoratorOfImage te = new TextExtractorDecoratorOfImage(
//				new TextExtractor());
		// te.extractURL("http://blog.sina.com.cn/s/blog_4cbec5e90100dgyy.html");
		// te.extractURL("http://news.sohu.com/20140216/n395065053.shtml");
		te.extractURL("http://news.163.com/14/0218/02/9LB4GS9300014AED.html");
		// te.extractURL("http://news.163.com/14/0217/02/9L8JP0Q800014AED.html");
		// te.extractURL("http://news.xinhuanet.com/politics/2014-02/17/c_119373970.htm");
		// te.extractURL("http://news.xinhuanet.com/politics/2014-02/17/c_119373758.htm");
		System.out.println(te.getTitle());
		System.out.println(te.getText());
		System.out.println(te.getImage());
	}
}

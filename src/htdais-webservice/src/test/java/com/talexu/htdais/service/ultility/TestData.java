package com.talexu.htdais.service.ultility;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.talexu.htdais.domain.QuantizedNews;

public class TestData {

	private static TestData instance;

	public static TestData getInstance() {
		if (instance == null) {
			instance = new TestData();
		}
		return instance;
	}

	private TestData() {

	}

	List<String> urls = new LinkedList<>(Arrays.asList(
			"http://news.163.com/14/0311/19/9N3290D500014JB6.html",
			"http://news.sina.com.cn/w/2014-03-15/145729715281.shtml",
			"http://sky.news.sina.com.cn/2014-03-15/014749365.html",
			"http://news.qq.com/a/20140315/006971.htm"));
	List<QuantizedNews> quantizedNewses;

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public List<QuantizedNews> getQuantizedNewses() {
		if (quantizedNewses == null) {
			quantizedNewses = new LinkedList<>();
			InputStream in = null;
			for (String url : urls) {
				try {
					in = new URL(url).openStream();
					String html = IOUtils.toString(in, "GB18030");
					QuantizedNews quantizedNew = new QuantizedNews();
					quantizedNew.setUri(url);
					quantizedNew.setHtml(html);
					quantizedNewses.add(quantizedNew);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					IOUtils.closeQuietly(in);
				}
			}
		}

		return quantizedNewses;
	}

	public void setQuantizedNewses(List<QuantizedNews> quantizedNewses) {
		this.quantizedNewses = quantizedNewses;
	}

}

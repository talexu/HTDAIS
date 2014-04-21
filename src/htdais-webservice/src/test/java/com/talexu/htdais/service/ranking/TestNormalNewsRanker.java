package com.talexu.htdais.service.ranking;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.processor.NewsProcessor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class TestNormalNewsRanker {

	Logger logger = LoggerFactory.getLogger(TestNormalNewsRanker.class);

	Pattern htmlPattern = Pattern.compile(".*?mirror/(.*?.(htm|html|shtml))$",
			Pattern.CASE_INSENSITIVE);

	String prefix = "/Users/bjutales/Downloads/news";

	@Autowired
	@Qualifier("cleanProcessor")
	NewsProcessor newsProcessor;
	@Autowired
	@Qualifier("normalNewsRanker")
	NewsRanker newsRanker;

	List<QuantizedNews> quantizedNews = new LinkedList<>();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExecute() {
		trainByTestNews(prefix);
		logger.debug("{}, {}", latestCalendar.getTime(), latestCalendar.getTimeInMillis());
		
		quantizedNews = newsRanker.execute(quantizedNews);
		
		logger.debug("The size of the news is {}", quantizedNews.size());
		
//		for (QuantizedNews quantizedNew : quantizedNews) {
//			System.out.println(quantizedNew);
//		}
	}

	Calendar latestCalendar = null;
	private void trainByTestNews(String path) {

		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				System.out.println("文件夹是空的!");
				return;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						// System.out.println("文件夹:" + file2.getAbsolutePath());
						trainByTestNews(file2.getAbsolutePath());
					} else {
						// System.out.println("文件:" + file2.getAbsolutePath());

						Matcher matcher = htmlPattern.matcher(file2
								.getAbsolutePath());
						if (matcher != null && matcher.find()) {
							// System.out.println(matcher.group(1).trim());
							try {
								String uri = matcher.group(1).trim();

								Calendar calendar = Calendar.getInstance();
								calendar.setTimeInMillis(file2.lastModified());
								if (latestCalendar != null) {
									if (calendar.after(latestCalendar)) {
										latestCalendar = calendar;
									}
								}
								else {
									latestCalendar = calendar;
								}

								String html = FileUtils.readFileToString(file2,
										"GB18030");

								QuantizedNews quantizedNew = new QuantizedNews();
								quantizedNew.setUri(uri);
								quantizedNew.setCalendar(calendar);
								quantizedNew.setHtml(html);
								quantizedNews.add(newsProcessor
										.execute(quantizedNew));
								
								logger.debug("{}", quantizedNew.getTitle());

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
	}
}

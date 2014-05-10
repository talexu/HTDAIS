package com.talexu.htdais.web;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talexu.htdais.domain.NewsView;
import com.talexu.htdais.domain.QuantizedNews;
import com.talexu.htdais.service.processor.NewsProcessor;
import com.talexu.htdais.service.ranking.NewsRanker;

@Controller
@RequestMapping("/")
public class RawsController {

	Logger logger = LoggerFactory.getLogger(RawsController.class);

	Pattern htmlPattern = Pattern.compile(".*?mirror/(.*?.(htm|html|shtml))$",
			Pattern.CASE_INSENSITIVE);

	List<QuantizedNews> quantizedNews = new LinkedList<>();
	String prefix = "/Users/bjutales/Downloads/news";

	@Autowired
	@Qualifier("newsProcessor")
	NewsProcessor newsProcessor;
	@Autowired
	@Qualifier("newsRanker")
	NewsRanker newsRanker;
	@Autowired
	@Qualifier("carouselNewsRanker")
	NewsRanker carouselNewsRanker;

	// @Autowired
	// @Qualifier("contentPool")
	// ContentPool contentPool;

	@RequestMapping("/")
	public String index(Model model) {
		logger.info("Greetings from Spring Boot!");
		// model.addAttribute("newses", NewsView.getTestNewsViews());
		// model.addAttribute("carousels", NewsView
		// .getNewsViews(carouselNewsRanker.execute(NewsView
		// .getTestQuantizedNews())));

		if (quantizedNews.isEmpty()) {
			trainByTestNews(prefix);
		}
		quantizedNews = newsRanker.execute(quantizedNews);
		model.addAttribute("newses", NewsView.getNewsViews(quantizedNews));
		model.addAttribute("carousels", NewsView
				.getNewsViews(carouselNewsRanker.execute(quantizedNews)));

		return "index";
	}

	// @RequestMapping("/")
	// public @ResponseBody List<NewsView> index() {
	// if (quantizedNews.isEmpty()) {
	// trainByTestNews(prefix);
	// }
	// quantizedNews = newsRanker.execute(quantizedNews);
	//
	// return NewsView.getNewsViews(quantizedNews);
	// }

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
								} else {
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

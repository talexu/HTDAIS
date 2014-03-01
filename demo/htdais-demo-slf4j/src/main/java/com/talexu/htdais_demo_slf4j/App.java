package com.talexu.htdais_demo_slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(App.class);
		logger.info("Hello World");
	}
}

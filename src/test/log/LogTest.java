package com.dongnao.jxh.test;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogTest {
	private static final Logger logger = LogManager.getLogger(LogTest.class.getName());
	public static void main(String[] args) {
		logger.error("hello error");
		logger.fatal("asfasdfsds");
	}
}

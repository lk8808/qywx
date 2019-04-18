package com.qywx.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;

public class AppContextUtil {

	private static ApplicationContext applicationContext;
	
	public static void setApplicationContext(ApplicationContext context) {
		applicationContext = context;
	}
	  
	public static Object getBean(String beanId) {
		return applicationContext.getBean(beanId);
	}
	   
	public static ApplicationContext getAppContext() {
		return applicationContext;
	}
	  
}

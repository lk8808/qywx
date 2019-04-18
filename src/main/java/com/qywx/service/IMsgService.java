package com.qywx.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IMsgService {

	public String handlerMsg(HttpServletRequest request, HttpServletResponse response);
	
	public String test(HttpServletRequest request, HttpServletResponse response);
	
}

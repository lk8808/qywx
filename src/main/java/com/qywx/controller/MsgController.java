package com.qywx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qywx.service.IMsgService;

@RestController
@RequestMapping("/api")
public class MsgController {
	
	Logger logger = LoggerFactory.getLogger(MsgController.class);
	
	@Autowired
	private IMsgService msgService;

	@PostMapping("/msg")
	public String handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		logger.info("----------------接收微信发过来的消息------------------");
		
		// 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
		request.setCharacterEncoding("UTF-8"); 
		// 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
		response.setCharacterEncoding("UTF-8");
		
		String respXml = msgService.handlerMsg(request, response);
		logger.info("----------返回微信消息处理结果-----------------------:"+respXml);
	
		return respXml;
	}
	
	/**
	 * 验证企业微信配置URL有效性
	 * @return
	 */
	@GetMapping("/msg")
	public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		logger.info("----------------开始验证URL有效性------------------");
		// 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
		request.setCharacterEncoding("UTF-8"); 
		// 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
		response.setCharacterEncoding("UTF-8");
		
		String retMsg = msgService.test(request, response);
		if (retMsg == null || "".equals(retMsg)) {
			logger.info("----------------URL有效性验证失败------------------");
			return null;
		} 
		logger.info("----------------URL有效性验证成功------------------");
		
		return retMsg;
	}
	
}

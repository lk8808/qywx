package com.qywx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qywx.entity.Rt;
import com.qywx.service.ILoginService;

@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ILoginService loginService;

	@RequestMapping("/index")
	public String index(@RequestParam String code) {
		
		logger.info("正在登陆，参数code=" + code);
		
		Rt rt = loginService.login(code);
		
		if (!"000000".equals(rt.getCode())) {
			logger.error("登陆认证失败：" + rt.getMsg());
			return "noPermission";
		}
		logger.info("登陆成功");
		
		return "wxmain";
	}
}

package com.qywx.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qywx.service.IBaseService;

@RestController
@RequestMapping("/api")
public class BaseController {

	Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	private IBaseService baseService;
	
	@PostMapping(value="/verifyjs")
	public String verifyJs(@RequestParam String pageurl) {
		return baseService.verifyJS(pageurl);
	}
	
	@PostMapping(value="/workitemtodo", consumes="application/json")
	public String queryWorkitemsTodo(@RequestBody Map<String, Object> map) {
		return baseService.queryWorkitemsTodo(map);
	}
	
	@PostMapping(value="/workitemdone", consumes="application/json", produces="application/json")
	public String queryWorkitemsDone(@RequestBody Map<String, Object> map) {
		return baseService.queryWorkitemsDone(map);
	}
	
	@PostMapping(value="/noticelist", consumes="application/json", produces="application/json")
	public String queryNotices(@RequestBody Map<String, Object> map) {
		return baseService.queryNotices(map);
	}
	
	@PostMapping(value="/noticeview")
	public String getNotice(String entityid) {
		return baseService.getNotice(entityid);
	}
	
	@PostMapping(value="/noticeread")
	public String readNotice(String entityid) {
		return baseService.readNotice(entityid);
	}
	
	@PostMapping(value="/getbizdata", consumes="application/json", produces="application/json")
	public String getBizdata(@RequestBody Map<String, Object> map) {
		return baseService.getBizdata(map);
	}
	
	@PostMapping(value="/check", consumes="application/json", produces="application/json")
	public String check(@RequestBody Map<String, Object> map) {
		return baseService.check(map);
	}
}

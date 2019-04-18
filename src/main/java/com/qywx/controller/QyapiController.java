package com.qywx.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qywx.service.IQyapiService;

@RestController
@RequestMapping("/api")
public class QyapiController {
	
	@Autowired
	private IQyapiService qyapiService;
	
	@PostMapping(value="/sendmsg", consumes="application/json", produces="application/json")
	public Map<String, String> sendMsg(@RequestBody Map<String, Object> param) {
		return qyapiService.sendMsg(param);
	}

}

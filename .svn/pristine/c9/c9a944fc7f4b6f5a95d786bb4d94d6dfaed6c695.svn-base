package com.qywx.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qywx.service.IOrgService;

@RestController
@RequestMapping("/api/org")
public class OrgController {
	
	Logger logger = LoggerFactory.getLogger(OrgController.class);
	
	@Autowired
	private IOrgService orgService;

	@PostMapping(value="/emplist", consumes="application/json", produces="application/json")
	public String empList(@RequestBody Map<String, Object> map) {
		return orgService.empList(map);
	}
	
	@PostMapping(value="/deplistbylevel", consumes="application/json", produces="application/json")
	public String depListByLevel(@RequestBody Map<String, Object> map) {
		return orgService.depListByLevel(map);
	}
	
	@PostMapping(value="/deplistchild", consumes="application/json", produces="application/json")
	public String depListChild(@RequestBody Map<String, Object> map) {
		return orgService.depListChild(map);
	}
	
	@PostMapping(value="/parseres", consumes="application/json", produces="application/json")
	public String parseRes2Emp(@RequestBody Map<String, Object> map) {
		return orgService.parseRes2Emp(map);
	}
	
}

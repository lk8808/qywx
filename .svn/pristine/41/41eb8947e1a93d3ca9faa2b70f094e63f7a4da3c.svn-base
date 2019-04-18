package com.qywx.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qywx.service.IEmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {

	Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	private IEmailService emailService;
	
	@PostMapping("/count")
	public String count() {
		return emailService.count();
	}
	
	@PostMapping(value="/send", consumes="application/json", produces="application/json")
	public String sendEmail(@RequestBody Map<String, Object> map) {
		return emailService.sendEmail(map);
	}
	
	@PostMapping(value="/list", consumes="application/json", produces="application/json")
	public String list(@RequestBody Map<String, Object> map) {
		return emailService.list(map);
	}
	
	@PostMapping("/getemail")
	public String getEmail(String emailacptid, String emailid) {
		return emailService.getEmail(emailacptid, emailid);
	}
	
	@PostMapping("/read")
	public String readEmail(String recids) {
		return emailService.readEmail(recids);
	}
	
	@PostMapping("/del")
	public String delEmail(String ids, String flag, String optype) {
		return emailService.delEmail(ids, flag, optype);
	}
	
	@PostMapping("/rec")
	public String recEmail(String ids) {
		return emailService.recEmail(ids);
	}
}

package com.qywx.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qywx.api.PBankEmailApi;
import com.qywx.service.IEmailService;

@Service
public class EmailServiceImpl implements IEmailService {

	@Autowired
	private PBankEmailApi pbankEmailApi;
	
	public String count() {
		
		try {
			return pbankEmailApi.count();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String list(Map<String, Object> map) {
		
		try {
			return pbankEmailApi.list(map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getEmail(String emailacptid, String emailid) {
		
		try {
			return pbankEmailApi.getEmail(emailacptid, emailid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String readEmail(String recids) {
		try {
			return pbankEmailApi.readEmail(recids);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String delEmail(String ids, String flag, String optype) {
		try {
			return pbankEmailApi.delEmail(ids, flag, optype);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String recEmail(String ids) {
		try {
			return pbankEmailApi.recEmail(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String sendEmail(Map<String, Object> map) {
		try {
			return pbankEmailApi.sendEmail(map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

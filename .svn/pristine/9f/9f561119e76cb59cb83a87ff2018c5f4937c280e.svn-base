package com.qywx.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qywx.api.PBankBaseApi;
import com.qywx.service.IBaseService;
import com.qywx.utils.JsapiTicketUtil;
import com.qywx.utils.WXPropsUtil;

@Service
public class BaseServiceImpl implements IBaseService {
	
	Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Autowired
	private PBankBaseApi pBankApi;

	/**
	 * JS域名验证
	 */
	@Override
	public String verifyJS(String pageurl) {
		List<String> list = new ArrayList<String>(); 

		String noncestr = WXPropsUtil.getProperty("nonce");
		String jsapi_ticket = JsapiTicketUtil.getJsapiTicket();
		String timestamp = WXPropsUtil.getProperty("timestamp");
		list.add("noncestr=" + noncestr);
		list.add("jsapi_ticket=" + jsapi_ticket);
		list.add("timestamp=" + timestamp);
		list.add("url=" + pageurl);
		String signature = JsapiTicketUtil.getSignature4JS(list);
		String str = "{\"signature\":\"" + signature + "\",\"timestamp\":" + timestamp + ",\"noncestr\":\"" + noncestr + "\"}";

		return str;
	}

	public String queryWorkitemsTodo(Map<String, Object> map) {
		
		try {
			return pBankApi.queryWorkitemsTodo(map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String queryWorkitemsDone(Map<String, Object> map) {
		try {
			return pBankApi.queryWorkitemsDone(map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String queryNotices(Map<String, Object> map) {
		try {
			return pBankApi.queryNotices(map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getNotice(String entityid) {
		try {
			return pBankApi.getNotice(entityid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String readNotice(String entityid) {
		try {
			return pBankApi.readNotice(entityid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String delAttachs(Map<String, Object> map) {
		try {
			return pBankApi.delAttachs(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getBizdata(Map<String, Object> map) {
		try {
			return pBankApi.getBizdata(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String check(Map<String, Object> map) {
		try {
			return pBankApi.check(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

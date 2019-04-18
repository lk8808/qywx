package com.qywx.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qywx.constant.ApiURL;
import com.qywx.utils.HttpUtil;
import com.qywx.utils.JsonUtil;

@Component
public class PBankEmailApi {
	
	private Map<String, String> head = new HashMap<String, String>();
	
	@Autowired
	private HttpSession session;
	
	public void initHead() {
		head.put("Content-Type", "application/json;charset=UTF-8");
		String JSESSIONID = session != null ? (String)session.getAttribute("JSESSIONID") : "";
		head.put("Cookie", "JSESSIONID=" + JSESSIONID);
	}
	
	public String count() throws Exception {
		initHead();
		Map<String, String> retMap = HttpUtil.sendGet(ApiURL.EmailApiURL.PBANK_EMAIL_COUNT, "utf-8", head);
		String respData = (String)retMap.get("respData");
			
		return respData;
	}
	
	public String sendEmail(Map<String, Object> map) throws Exception {
		initHead();

		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.EmailApiURL.PBANK_EMAIL_SEND, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
		
		return respData;
	}
	
	public String list(Map<String, Object> map) throws Exception {
		initHead();

		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.EmailApiURL.PBANK_EMAIL_LIST, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
		
		return respData;
	}

	public String getEmail(String emailacptid, String emailid) throws Exception {
		initHead();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("emailacptid", emailacptid);
		map.put("emailid", emailid);
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.EmailApiURL.PBANK_EMAIL_GET, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
		
		return respData;
	}
	
	public String readEmail(String recids) throws Exception {
		initHead();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("recids", recids);
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.EmailApiURL.PBANK_EMAIL_READ, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
		
		return respData;
	}
	
	public String delEmail(String ids, String flag, String optype) throws Exception {
		initHead();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		map.put("flag", flag);
		map.put("optype", optype);
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.EmailApiURL.PBANK_EMAIL_DEL, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
		
		return respData;
	}
	
	public String recEmail(String ids) throws Exception {
		initHead();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.EmailApiURL.PBANK_EMAIL_REC, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
		
		return respData;
	}
}

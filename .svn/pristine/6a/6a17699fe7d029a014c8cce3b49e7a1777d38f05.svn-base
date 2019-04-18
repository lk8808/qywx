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
public class PBankOrgApi {

private Map<String, String> head = new HashMap<String, String>();
	
	@Autowired
	private HttpSession session;
	
	public void initHead() {
		head.put("Content-Type", "application/json;charset=UTF-8");
		String JSESSIONID = session != null ? (String)session.getAttribute("JSESSIONID") : "";
		head.put("Cookie", "JSESSIONID=" + JSESSIONID);
	}
	
	public String empList(Map<String, Object> map) throws Exception {
		initHead();
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.OrgApiURL.PBANK_ORG_EMPLIST, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
		
		return respData;
	}
	
	public String depListByLevel(Map<String, Object> map) throws Exception {
		initHead();
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.OrgApiURL.PBANK_ORG_DEPLISTBYLEVEL, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
		
		return respData;
	}
	
	public String depListChild(Map<String, Object> map) throws Exception {
		initHead();
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.OrgApiURL.PBANK_ORG_DEPCHILDLIST, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
		
		return respData;
	}
	
	public String parseRes2Emp(Map<String, Object> map) throws Exception {
		initHead();
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.OrgApiURL.PBANK_ORG_PARSERES, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
		
		return respData;
	}
}

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
public class PBankBaseApi {
	
	private Map<String, String> head = new HashMap<String, String>();
	
	@Autowired
	private HttpSession session;
	
	public void initHead() {
		head.put("Content-Type", "application/json;charset=UTF-8");
		String JSESSIONID = session != null ? (String)session.getAttribute("JSESSIONID") : "";
		head.put("Cookie", "JSESSIONID=" + JSESSIONID);
	}

	/**
	 * 登陆
	 * @param userid 用户名
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> login(String userid) throws Exception {
		initHead();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.PBANK_PORTAL_LOGIN, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
		map = JsonUtil.JsonToMap(respData);
		
		return map;
	}
	
	/**
	 * 删除附件
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public String delAttachs(Map<String, Object> map) throws Exception {
		initHead();

		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.PBANK_DOCS_DELATTACH, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
			
		return respData;
	}
	
	/**
	 * 查询待处理任务
	 * @param title
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public String queryWorkitemsTodo(Map<String, Object> map) throws Exception {
		initHead();

		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.PBANK_PROCESS_QUERYWORKITEMSTODO, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
			
		return respData;
	}
	
	/**
	 * 查询已处理任务
	 * @param title
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public String queryWorkitemsDone(Map<String, Object> map) throws Exception {
		initHead();
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.PBANK_PROCESS_QUERYWORKITEMSDONE, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
			
		return respData;
	}
	
	/**
	 * 查询公告
	 * @param title
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public String queryNotices(Map<String, Object> map) throws Exception {
		initHead();
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.PBANK_INFO_QUERYNOTICE, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
			
		return respData;
	}
	
	public String getNotice(String entityid) throws Exception {
		initHead();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("entityid", entityid);
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.PBANK_INFO_GETNOTICE, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
			
		return respData;
	}
	
	public String readNotice(String entityid) throws Exception {
		initHead();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bizdataid", entityid);
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.PBANK_INFO_READNOTICE, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
			
		return respData;
	}
	
	public String getBizdata(Map<String, Object> map) throws Exception {
		initHead();
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.PBANK_PROCESS_GETBIZDATA, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
			
		return respData;
	}
	
	public String check(Map<String, Object> map) throws Exception {
		initHead();
		String param = JsonUtil.MapToJson(map);
		Map<String, String> retMap = HttpUtil.sendPost(ApiURL.PBANK_PROCESS_CHECK, param, "utf-8", head);
		String respData = (String)retMap.get("respData");
			
		return respData;
	}
	
}

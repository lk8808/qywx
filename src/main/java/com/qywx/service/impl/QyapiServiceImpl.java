package com.qywx.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.qywx.api.QywxApi;
import com.qywx.service.IQyapiService;
import com.qywx.utils.QywxUtil;

@Service
public class QyapiServiceImpl implements IQyapiService {
	
	Logger logger = LoggerFactory.getLogger(QyapiServiceImpl.class);

	public Map<String, String> sendMsg(Map<String, Object> param) {
		Map<String, String> retMap = null;
		String currentdate = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
		JsonObject jsonParam = new JsonObject();
		JsonObject textcard = new JsonObject();
		
		try {
			String touser = (String)param.get("touser");
			String activityinstname = (String)param.get("activityinstname");
			String workitemname = (String)param.get("workitemname");
			String starttime = (String)param.get("starttime");
			String appemp = (String)param.get("appemp");
			
			jsonParam.addProperty("touser", touser);
			jsonParam.addProperty("msgtype", QywxUtil.MSGTYPE_TEXTCARD);
			jsonParam.addProperty("agentid", QywxUtil.AgentId);
			textcard.addProperty("title", "工作提醒");
			String description = "<div class=\"gray\">" + currentdate + "</div> "
					+ "<div class=\"normal\">任务名称:" + activityinstname + "</div>"
					+ "<div class=\"normal\">任务详情:" + workitemname + "</div>"
					+ "<div class=\"normal\">开始时间:" + starttime + "</div>"
					+ "<div class=\"normal\">提交人:" + appemp + "</div>";
			textcard.addProperty("description", description);
			jsonParam.add("textcard", textcard);
			retMap = QywxApi.sendMsg(jsonParam.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retMap;
	}

}

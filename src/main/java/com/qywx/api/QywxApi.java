package com.qywx.api;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.qywx.utils.AccessTokenUtil;
import com.qywx.utils.HttpUtil;

public class QywxApi {

	/**
	 * 获取用户信息
	 * @param code
	 * @return
	 */
	public static Map<String, String> getUserInfoByCode(String code) {
		Map<String, String> retMap = new HashMap<String, String>();
		String url = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token="
				+ AccessTokenUtil.getAccessToken() + "&code=" + code;
		//发送请求获取用户信息
		Map<String, String> map = HttpUtil.sendGet(url, "utf-8", null);
		//获取并解析响应报文
		String respData = map.get("respData");
		JsonObject jsonObj = new JsonParser().parse(respData).getAsJsonObject();
		retMap.put("UserId", jsonObj.get("UserId").getAsString());
		retMap.put("DeviceId", jsonObj.get("DeviceId").getAsString());
		retMap.put("errcode", jsonObj.get("errcode").getAsString());
		retMap.put("errmsg", jsonObj.get("errmsg").getAsString());

		return retMap;
	}
	
	/**
	 * 发送消息接口
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> sendMsg(String params) throws Exception {
		Map<String, String> retMap = new HashMap<String, String>();
		String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token="
				+ AccessTokenUtil.getAccessToken();

		Map map = HttpUtil.sendPost(url, params, "utf-8", null);
		String respData = (String) map.get("respData");
		JsonObject jsonObj = new JsonParser().parse(respData)
				.getAsJsonObject();
		String errcode = jsonObj.get("errcode").getAsString();
		String errmsg = jsonObj.get("errmsg").getAsString();
		retMap.put("errcode", errcode);
		retMap.put("errmsg", errmsg);

		return retMap;
	}
}

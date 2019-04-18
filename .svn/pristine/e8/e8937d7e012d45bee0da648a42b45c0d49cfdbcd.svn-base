package com.qywx.utils;

import java.util.Date;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AccessTokenUtil {

	private static String access_token = "";
	
	private static Date lastime = null;
	
	public static String getAccessToken() {
		loadAccessToken();
		return access_token;
	}
	
	private static void loadAccessToken() {
		//获取access_token的地址
		String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + QywxUtil.CorpID + "&corpsecret=" + QywxUtil.ProviderSecret;
		
		if ("".equals(access_token) || isExpired()) {
			//发送请求获取access_token
			Map retMap = HttpUtil.sendGet(url, "utf-8", null);
			//获取并解析响应报文
			String respData = (String)retMap.get("respData");
			JsonObject jsonObj = new JsonParser().parse(respData).getAsJsonObject();
			String str = jsonObj.get("access_token").getAsString();
			//更新access_token并更新最后更新时间
			if ( str != null && !"".equals(str) ) {
				access_token = str;
				WXPropsUtil.setProperty("access_token", str);
				lastime = new Date();
			}
		}
	}
	
	/**
	 * 判断access_token是否过期，access_token有效时间为7200秒
	 * @return
	 */
	private static boolean isExpired() {
		if (lastime == null) {
			return true;
		}
		
		long t1 = lastime.getTime();
		long t2 = new Date().getTime();
		//比较当前的时间和最后一次获取access_token的时间
		if ( (int)((t2-t1)/1000) >= 7200 ) {
			return true;
		}
		
		return false;
	}
	
}

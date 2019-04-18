package com.qywx.utils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * jsapi_ticket获取类
 * @author liuk1
 *
 */
public class JsapiTicketUtil {

	private static String JSAPI_TICKETUTIL = "";
	
	private static Date LASTTIME = null;
	
	public static String getJsapiTicket() {
		loadJsapiTicket();
		return JSAPI_TICKETUTIL;
	}
	
	private static void loadJsapiTicket() {
		
		String access_token = AccessTokenUtil.getAccessToken();
		//获取jsapi_ticket的地址
		String url = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=" + access_token;
		
		if ("".equals(JSAPI_TICKETUTIL) || isExpired()) {
			//发送请求获取ticket
			Map retMap = HttpUtil.sendGet(url, "utf-8", null);
			//解析响应，取得ticket
			String respData = (String)retMap.get("respData");
			JsonObject jsonObj = new JsonParser().parse(respData).getAsJsonObject();
			String jsapi_ticket = jsonObj.get("ticket").getAsString();
			//更新ticket并更新最后更新时间
			if ( jsapi_ticket != null && !"".equals(jsapi_ticket) ) {
				JSAPI_TICKETUTIL = jsapi_ticket;
				WXPropsUtil.setProperty("jsapi_ticket", jsapi_ticket);
				LASTTIME = new Date();
			}
		}
	}
	
	/**
	 * 判断jsapi_ticket是否过期，jsapi_ticket有效时间为7200秒
	 * @return
	 */
	private static boolean isExpired() {
		if (LASTTIME == null) {
			return true;
		}
		
		long t1 = LASTTIME.getTime();
		long t2 = new Date().getTime();
		//比较当前的时间和最后一次获取access_token的时间
		if ( (int)((t2-t1)/1000) >= 7200 ) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 获取签名(微信前台接口验证)
	 * @param list
	 * @return
	 */
	public static String getSignature4JS(List<String> list) {
		Collections.sort(list);
		String content = "";
		for (int i=0; i<list.size(); i++) {
			if ("".equals(content)) {
				content = list.get(i);
			} else {
				content = content + "&" + list.get(i);
			}
		}
		String signature = DigestUtils.shaHex(content.toString());

		return signature;
	}
}

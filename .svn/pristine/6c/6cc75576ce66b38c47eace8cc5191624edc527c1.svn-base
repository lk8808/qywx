package com.qywx.service.impl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qywx.api.PBankBaseApi;
import com.qywx.api.QywxApi;
import com.qywx.entity.Rt;
import com.qywx.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private PBankBaseApi pBankApi;

	@SuppressWarnings("rawtypes")
	public Rt login(String code) {
		
		Rt rt = new Rt("000000", "");
		
		try {
			//调用企业微信接口获取userid
			Map<String, String> map = QywxApi.getUserInfoByCode(code);
			String userid = map.get("UserId");
			if (userid == null || "".equals(userid)) {
				rt.setCode("000001");
				rt.setMsg("用户userid获取失败");
				return rt;
			}
//			String userid = "0001";
			//调用流程银行接口进行登陆
			Map<String, Object> retMap = pBankApi.login(userid);
			logger.info(retMap.toString());
			String rtCode = (String)retMap.get("rtCode");
			String rtMsg = (String)retMap.get("rtMsg");
			Map userObject = (Map)retMap.get("userObject");
			String JSESSIONID = userObject != null ? (String)userObject.get("sessionId") : "";
			session.setAttribute("userObject", userObject);
			session.setAttribute("JSESSIONID", JSESSIONID);
			
			if ("0".equals(rtCode)) {
				rt.setCode("900009");
				rt.setMsg(rtMsg);
			}
			
		} catch (Exception e) {
			rt.setCode("999999");
			rt.setMsg("流程银行登陆接口调用异常");
			e.printStackTrace();
		}
		
		return rt;
	}

}

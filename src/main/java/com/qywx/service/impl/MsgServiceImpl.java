package com.qywx.service.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qywx.aes.AesException;
import com.qywx.aes.WXBizMsgCrypt;
import com.qywx.bean.TextMessage;
import com.qywx.service.IMsgService;
import com.qywx.utils.QywxUtil;
import com.qywx.utils.WXPropsUtil;
import com.qywx.utils.XmlParser;

@Service
public class MsgServiceImpl implements IMsgService {
	
	Logger logger = LoggerFactory.getLogger(MsgServiceImpl.class);
	
	/**
	 * 消息处理
	 */
	public String handlerMsg(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("------------微信消息开始处理-------------");
		String respXml = "";
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String msg_signature = request.getParameter("msg_signature");
		
		try {
			String postData = XmlParser.getXml(request);
			//解密
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(QywxUtil.Token, QywxUtil.EncodingAESKey, QywxUtil.CorpID);
			String xmlStr = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, postData);
			Map<String, String> reqMap = XmlParser.parseXml(xmlStr);
			respXml = handlerMsg(reqMap);
			//加密
			respXml = wxcpt.EncryptMsg(respXml, timestamp, nonce);
			
		} catch (Exception e) {
			logger.error("------------微信消息处理失败-------------");
			e.printStackTrace();
			return null;
		}
		
		return respXml;
	}
	
	private String handlerMsg(Map<String, String> reqMap) {
		String respXml = "";
		String fromUserName = reqMap.get("FromUserName");
		String toUserName = reqMap.get("ToUserName");
		String msgType = reqMap.get("MsgType");
		logger.info("fromUserName is:" +fromUserName+" toUserName is:" +toUserName+" msgType is:" +msgType);
		
		// 默认回复文本消息
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(QywxUtil.MSG_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		
		switch (msgType) {
			case QywxUtil.MSG_TYPE_TEXT:
				textMessage.setContent("文本消息");	
				break;
			case QywxUtil.MSG_TYPE_IMAGE:
				textMessage.setContent("图片消息");	
				break;
			case QywxUtil.MSG_TYPE_EVENT:
				textMessage.setContent("事件消息");
				break;
			default:
				break;
		}
		respXml = XmlParser.textMessageToXml(textMessage);
		
		return respXml;
	}

	/**
	 * URL验证
	 */
	public String test(HttpServletRequest request, HttpServletResponse response) {

		String sEchoStr = "";
		
		String msg_signature = request.getParameter("msg_signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		WXPropsUtil.setProperty("msg_signature", msg_signature);
		WXPropsUtil.setProperty("timestamp", timestamp);
		WXPropsUtil.setProperty("nonce", nonce);
		WXPropsUtil.setProperty("echostr", echostr);
		
		try {
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(QywxUtil.Token, QywxUtil.EncodingAESKey, QywxUtil.CorpID);
			sEchoStr = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
		} catch (AesException e) {
			e.printStackTrace();
		}

		return sEchoStr;
	}

}

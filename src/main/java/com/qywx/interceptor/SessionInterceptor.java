package com.qywx.interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

@Component
public class SessionInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		HttpSession session = request.getSession(true);
		Map userObject = (Map)session.getAttribute("userObject");
		if (userObject != null) {
			return true;
		}
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8");
	    
		PrintWriter printWriter = response.getWriter();
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("code", "000009");
		jsonObj.addProperty("msg", "会话已失效!");
        printWriter.write(jsonObj.toString());
        
        printWriter.close();
		
		return false;
	}

}
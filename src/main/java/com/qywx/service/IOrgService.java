package com.qywx.service;

import java.util.Map;

public interface IOrgService {

	public String empList(Map<String, Object> map);
	
	public String depListByLevel(Map<String, Object> map);
	
	public String depListChild(Map<String, Object> map);
	
	public String parseRes2Emp(Map<String, Object> map);
	
}

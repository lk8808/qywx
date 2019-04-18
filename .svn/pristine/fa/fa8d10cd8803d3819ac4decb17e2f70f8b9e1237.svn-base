package com.qywx.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qywx.api.PBankOrgApi;
import com.qywx.service.IOrgService;

@Service
public class OrgServiceImpl implements IOrgService {
	
	@Autowired
	private PBankOrgApi pBankOrgApi;

	public String empList(Map<String, Object> map) {
		try {
			return pBankOrgApi.empList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String depListByLevel(Map<String, Object> map) {
		try {
			return pBankOrgApi.depListByLevel(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String depListChild(Map<String, Object> map) {
		try {
			return pBankOrgApi.depListChild(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String parseRes2Emp(Map<String, Object> map) {
		try {
			return pBankOrgApi.parseRes2Emp(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

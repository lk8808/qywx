package com.qywx.constant;

public final class ApiURL {
	
	private ApiURL(){}
	
	final static String HOST = "http://127.0.0.1:8080/pbank/";
	
	public final static String PBANK_DOCS_DOWNLOADURL = HOST + "/comm/comm/downloadByFilepath.jsp";
	
	public final static String PBANK_DOCS_UPLOAD = HOST + "com.qywx.api.docs.docsCom.addAttach.biz.ext";
	
	public final static String PBANK_DOCS_DELATTACH = HOST + "com.qywx.api.docs.docsCom.delAttachs.biz.ext";

	public final static String PBANK_PORTAL_LOGIN = HOST + "com.qywx.api.portal.loginCom.login4WX.biz.ext";
	
	public final static String PBANK_PROCESS_QUERYWORKITEMSTODO = HOST + "com.qywx.api.process.workItemCom.queryTodoWorkItems.biz.ext";
	
	public final static String PBANK_PROCESS_QUERYWORKITEMSDONE = HOST + "com.qywx.api.process.workItemCom.queryDoneWorkitems.biz.ext";
	
	public final static String PBANK_INFO_QUERYNOTICE = HOST + "com.qywx.api.info.notice.noticeCom.queryNoticereads.biz.ext";
	
	public final static String PBANK_INFO_GETNOTICE = HOST + "com.qywx.api.info.notice.noticeCom.getNotice.biz.ext";
	
	public final static String PBANK_INFO_READNOTICE =  HOST + "biz.notice.noticeCom.updateNoticeread.biz.ext";
	
	public final static String PBANK_PROCESS_GETBIZDATA = HOST + "com.qywx.api.process.workItemCom.getBizData.biz.ext";
	
	public final static String PBANK_PROCESS_CHECK = HOST + "biz.checktask.checktaskCom.addChecktask.biz.ext";
	
	public class EmailApiURL{
		
		public final static String PBANK_EMAIL_COUNT = HOST + "biz.email.emailCom.countEmail4Menu.biz.ext";
		
		public final static String PBANK_EMAIL_SEND = HOST + "com.qywx.api.info.email.emailCom.addEmail.biz.ext";
		
		public final static String PBANK_EMAIL_LIST = HOST + "biz.email.emailCom.queryEmailByProperty.biz.ext";
		
		public final static String PBANK_EMAIL_GET = HOST + "com.qywx.api.info.email.emailCom.getEmail.biz.ext";
		
		public final static String PBANK_EMAIL_READ = HOST + "com.qywx.api.info.email.emailCom.readEmail.biz.ext";
		
		public final static String PBANK_EMAIL_DEL = HOST + "com.qywx.api.info.email.emailCom.delEmails.biz.ext";
		
		public final static String PBANK_EMAIL_REC = HOST + "com.qywx.api.info.email.emailCom.restoreEmails.biz.ext";
		
	}
	
	public class OrgApiURL {
		
		public final static String PBANK_ORG_EMPLIST = HOST + "biz.employee.employeeCom.queryEmployeeByCriteria.biz.ext";
		
		public final static String PBANK_ORG_DEPLISTBYLEVEL = HOST + "com.qywx.api.org.departmentCom.queryDepartmentsByLevel.biz.ext";
		
		public final static String PBANK_ORG_DEPCHILDLIST = HOST + "com.qywx.api.org.departmentCom.queryDepartmentsByParentid.biz.ext";
		
		public final static String PBANK_ORG_PARSERES = HOST + "biz.employee.employeeCom.getEmps4MultSelect.biz.ext";
		
	}
	
}

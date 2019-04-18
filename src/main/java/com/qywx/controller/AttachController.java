package com.qywx.controller;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qywx.constant.ApiURL;
import com.qywx.service.IBaseService;

@Controller
@RequestMapping("/api")
public class AttachController {
	
	Logger logger = LoggerFactory.getLogger(AttachController.class);
	
	@Autowired
	private IBaseService baseService;

	@RequestMapping("/download")
	public void fileDownload(@RequestParam String filepath, @RequestParam String filename, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			filepath = URLDecoder.decode(filepath, "utf-8");
			filename = URLDecoder.decode(filename, "utf-8");
			
			//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型   
	        response.setContentType("multipart/form-data");   
	        response.setCharacterEncoding("UTF-8");
	        //2.设置文件头：最后一个参数是设置下载文件名 
	        response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20").replaceAll("%28", "\\(").replaceAll("%29", "\\)").replaceAll("%3B", ";").replaceAll("%40", "@").replaceAll("%23", "\\#").replaceAll("%26", "\\&").replaceAll("%5B", "\\[").replaceAll("%5D", "\\]"));
			
			URL realUrl = new URL(ApiURL.PBANK_DOCS_DOWNLOADURL + "?filePath=" + filepath + "&fileName=" + filename);
			logger.info("文件下载地址：" + realUrl);
			
			URLConnection conn = realUrl.openConnection();
			InputStream in = conn.getInputStream();
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[2048];
	        int length;
	        while ((length = in.read(b)) > 0) {
	            os.write(b, 0, length);
	        }
	 
	        os.close();
	        in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/upload")
	public void fileUpload(@RequestParam String entityname, 
							 @RequestParam String entityid, 
							 @RequestParam String filter,
							 MultipartHttpServletRequest request, 
							 HttpServletResponse response) {
		
		logger.info("开始上传文件");
		
		// 设置三个常用字符串常量：换行、前缀、分界线（NEWLINE、PREFIX、BOUNDARY）
		final String NEWLINE = "\r\n";
		final String PREFIX = "--";
		final String BOUNDARY = "*******A********A********A******";
		HttpURLConnection conn = null;
		DataOutputStream dos = null;
		BufferedInputStream bis = null;
		OutputStream out = null;
		try {

			URL realUrl = new URL(ApiURL.PBANK_DOCS_UPLOAD);
			conn = (HttpURLConnection)realUrl.openConnection();
			
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			// 设置Http请求头信息
			conn.setUseCaches(false);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			conn.setRequestProperty("Cache-Control", "no-cache");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary="+BOUNDARY);
			conn.setRequestProperty("User-Agent", request.getHeader("User-Agent"));
			conn.connect();
			
			//写入参数
			dos = new DataOutputStream(conn.getOutputStream());
			if (entityname != null) {
				dos.writeBytes(PREFIX + BOUNDARY + NEWLINE);//分割线
				dos.writeBytes("Content-Disposition: form-data; name=\"entityname\"" + NEWLINE);
				dos.writeBytes(NEWLINE); // 空行
				dos.writeBytes(URLEncoder.encode(entityname.toString(), "utf-8"));
				dos.writeBytes(NEWLINE); // 换行
			}
			if (entityid != null) {
				dos.writeBytes(PREFIX + BOUNDARY + NEWLINE);//分割线
				dos.writeBytes("Content-Disposition: form-data; name=\"entityid\"" + NEWLINE);
				dos.writeBytes(NEWLINE); // 空行
				dos.writeBytes(URLEncoder.encode(entityid.toString(), "utf-8"));
				dos.writeBytes(NEWLINE); // 换行
			}
			if (filter != null) {
				dos.writeBytes(PREFIX + BOUNDARY + NEWLINE);//分割线
				dos.writeBytes("Content-Disposition: form-data; name=\"filter\"" + NEWLINE);
				dos.writeBytes(NEWLINE); // 空行
				dos.writeBytes(URLEncoder.encode(filter.toString(), "utf-8"));
				dos.writeBytes(NEWLINE); // 换行
			}
			//写入文件
			MultipartFile insertFile = request.getFile("insertFile");
			String filename = insertFile.getOriginalFilename();
			dos.writeBytes(PREFIX + BOUNDARY + NEWLINE);//分割线
			// 格式是:Content-Disposition: form-data; name="请求参数名"; filename="文件名"
			dos.writeBytes("Content-Disposition: form-data; name=\"insertFile\"; filename=\"");
			dos.write(filename.getBytes("utf-8"));
			dos.writeBytes("\"" + NEWLINE);
			dos.writeBytes(NEWLINE); // 空行
			//文件内容
			dos.write(insertFile.getBytes());
			dos.writeBytes(NEWLINE); // 换行
			dos.writeBytes(PREFIX + BOUNDARY + PREFIX + NEWLINE);//最后的分割线
			dos.flush();
			
			byte[] b = new byte[2048];
	        int length;
	        out = response.getOutputStream();
	        if (conn.getResponseCode() == 200) {
	        	bis = new BufferedInputStream(conn.getInputStream());
	        	while ((length = bis.read(b)) != -1) {
	        		out.write(b, 0, length);
	        	}
	        }

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null)
                    dos.close();
                if (bis != null)
                    bis.close();
                if (out != null)
                	out.close();
                conn.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@ResponseBody
	@PostMapping(value="/delattachs", consumes="application/json", produces="application/json")
	public String delAttachs(@RequestBody Map<String, Object> map) {
		return baseService.delAttachs(map);
	}
}

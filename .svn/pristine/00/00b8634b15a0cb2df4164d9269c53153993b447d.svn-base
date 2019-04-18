package com.qywx.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.util.ResourceUtils;

/**
 * 用于存放持久变量
 * @author liuk1
 *
 */
public class WXPropsUtil {

	private static Properties props;
	
	private static String filepath = "";
	
	static {
		String cfgPath = "";
		try {
			cfgPath = ResourceUtils.getURL("classpath:").getPath();
			filepath = cfgPath + File.separator + "wxcfg";
			File file = new File(filepath);
			if (!file.isDirectory()) {
				file.mkdirs();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		filepath = cfgPath + File.separator + "wxcfg" + File.separator + "wx.properties";
	}
	
	private synchronized static void loadProps() {
		props = new Properties();
        InputStream in = null;
        try {
        	File file = new File(filepath);
        	if ( !file.exists() ) {
    			file.createNewFile();
            }
        	in = new FileInputStream(file);
			props.load(in);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				if ( in != null ) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 通过key获取变量值
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
	}

	/**
	 * 设置变量
	 * @param key
	 * @param value
	 */
	public static void setProperty(String key, String value) {
		if(null == props) {
            loadProps();
        }
		OutputStream os = null;
		try {
			os = new FileOutputStream(filepath);
			props.setProperty(key, value);
			props.store(os, "");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}

}

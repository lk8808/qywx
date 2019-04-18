package com.qywx.aes;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {  
	
	//private static Encoder encode = Base64.getEncoder();
	
	//private static Decoder decoder = Base64.getDecoder();
    // 加密  
    public static String encode(String str) {  
        byte[] b = null;  
        String s = null;  
        try {  
            b = str.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        if (b != null) {  
            //s = encode.encodeToString(b);
        	s = Base64.encodeBase64String(b);
            //据RFC 822规定，每76个字符，还需要加上一个回车换行去掉换行符  
            s = s.replaceAll("[\\s*\t\n\r]", "");    
        }  
        return s;  
    }  
    
    public static String encode(byte[] bytes) {
    	String s = null;  
        if (bytes != null) {  
            //s = encode.encodeToString(bytes);
        	s = Base64.encodeBase64String(bytes);
            //据RFC 822规定，每76个字符，还需要加上一个回车换行去掉换行符  
            s = s.replaceAll("[\\s*\t\n\r]", "");    
        }  
        return s;
    }
  
    // 解密  
    public static String decode(String s) {  
        byte[] b = null;  
        String result = null;  
        if (s != null) {  
            try {  
                //b = decoder.decode(s);
            	b = Base64.decodeBase64(s);
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
    public static void main(String[] args){  
        String s = "你好";  
        String enStr = encode(s);   
        System.out.println(enStr); 
    }  
}  
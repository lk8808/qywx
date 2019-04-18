package com.qywx.bean;

/**
 * 图片消息
 * @author liuk1
 *
 */
public class ImageMessage extends BaseMessage {

	private String PicUrl;
	
	private String MediaId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		this.PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		this.MediaId = mediaId;
	}

}

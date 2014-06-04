package com.meizhuangge.message.request;

/**
 * @author Leevin
 * ImageMessage
 */
public class ImageMessage extends BaseMessage{

	//图片地址
	private String PicUrl;
	//图片消息媒体ID
	private int MediaId;

	public ImageMessage() {
	}
	
	public ImageMessage(String picUrl) {
		super();
		PicUrl = picUrl;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public int getMediaId() {
		return MediaId;
	}

	public void setMediaId(int mediaId) {
		MediaId = mediaId;
	}
	
}

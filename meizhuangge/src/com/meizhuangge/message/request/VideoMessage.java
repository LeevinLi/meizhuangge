package com.meizhuangge.message.request;

public class VideoMessage {

	// 媒体ID
	private int MediaId;
	// 视频缩略图ID
	private int ThumbMediaId;

	public VideoMessage() {
	}

	public VideoMessage(int mediaId, int thumbMediaId) {
		super();
		MediaId = mediaId;
		ThumbMediaId = thumbMediaId;
	}

	public int getMediaId() {
		return MediaId;
	}

	public void setMediaId(int mediaId) {
		MediaId = mediaId;
	}

	public int getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(int thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}

package com.meizhuangge.message.response;

/**
 * @author Leevin
 * @date 2014-03-18TextMessage
 */
public class TextMessage extends BaseMessage {

	// 消息内容
	private String Content;

	public TextMessage() {
	}

	public TextMessage(String content) {
		super();
		Content = content;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}

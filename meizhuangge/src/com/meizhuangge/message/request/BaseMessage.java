package com.meizhuangge.message.request;

/**
 * @author Leevin BaseMessage
 */
public class BaseMessage {
	// 开发者微信号
	private String ToUserName;
	// 发送方帐号(OpenID)
	private String FromUserName;
	// 消息创建时间
	private long CreateTime;
	// 消息类型(text/image/location/link)
	private String MsgType;
	// 消息ID,64位整型
	private long MsgId;

	public BaseMessage() {
	}

	public BaseMessage(String toUserName, String fromUserName, long createTime,
			String msgType, long msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		MsgId = msgId;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
}
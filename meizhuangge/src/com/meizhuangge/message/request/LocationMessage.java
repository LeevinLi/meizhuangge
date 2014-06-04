package com.meizhuangge.message.request;

/**
 * @author Leevin
 * LocationMessage
 * 2014-3-18
 */
public class LocationMessage extends BaseMessage {

	// 纬度
	private String Location_X;
	// 经度
	private String Location_Y;
	// 缩放大小
	private String Scale;
	// 地理位置
	private String Label;

	public LocationMessage() {
	}

	public LocationMessage(String location_X, String location_Y, String scale,
			String label) {
		super();
		Location_X = location_X;
		Location_Y = location_Y;
		Scale = scale;
		Label = label;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}
}

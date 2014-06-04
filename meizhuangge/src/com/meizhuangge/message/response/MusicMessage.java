package com.meizhuangge.message.response;

import com.meizhuangge.model.Music;

/**
 * 音乐消息
 * 
 * @author Leevin
 * @date 2014-03-18
 */
public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	public MusicMessage(com.meizhuangge.model.Music music) {
		super();
		Music = music;
	}

	public MusicMessage() {
	}

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}

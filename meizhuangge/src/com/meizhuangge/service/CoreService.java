package com.meizhuangge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meizhuangge.message.response.NewsMessage;
import com.meizhuangge.message.response.TextMessage;
import com.meizhuangge.model.Article;
import com.meizhuangge.utils.MessageUtil;

/**
 * 核心服务类
 * 
 * @author Leevin
 * @date 2014-03-20
 */
public class CoreService {

	private static Logger log = LoggerFactory.getLogger(CoreService.class);

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 默认回复此文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			// 由于href属性值必须用双引号引起，这与字符串本身的双引号冲突，所以要转义
			StringBuffer contentMsg = new StringBuffer();
			contentMsg
					.append("欢迎访问<a href=\"http://www.baidu.com/p/%E4%BF%A1%E4%BB%A5%E4%B8%BA%E7%9C%9F2011?from=pic\">个人主页</a>")
					.append("\n");
			contentMsg.append("您好，我是机器人麦琪，请回复数字选择服务:").append("\n\n");

			contentMsg.append("1 :微信公众平台开发").append("\n");
			contentMsg.append("2 :百度个人中心").append("\n");
			contentMsg.append("3 :微信多图文开发").append("\n");
			contentMsg.append("4 :软件截屏").append("\n");
			/*
			 * contentMsg.append("1 :天气预报").append("\n");
			 * contentMsg.append("2 :公交查询").append("\n");
			 * contentMsg.append("3 :周边搜索").append("\n");
			 * contentMsg.append("4 :歌曲点播").append("\n");
			 * contentMsg.append("5 :经典游戏").append("\n");
			 * contentMsg.append("6 :美女电台").append("\n");
			 * contentMsg.append("7 :人脸识别").append("\n");
			 * contentMsg.append("8 :聊天唠嗑").append("\n");
			 * contentMsg.append("9 :电影排行榜").append("\n");
			 * contentMsg.append("10 :Q友圈").append("\n\n");
			 */

			contentMsg
					.append("点击查看 <a href=\"http://meizhuangge.duapp.com\">网站首页</a>");

			textMessage.setContent(contentMsg.toString());
			// 将文本消息对象转换成xml字符串
			respMessage = MessageUtil.textMessageToXml(textMessage);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				// 接收用户发送的文本消息内容
				String content = requestMap.get("Content");

				// 创建图文消息
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
				newsMessage.setFuncFlag(0);

				List<Article> articleList = new ArrayList<Article>();
				// 单图文消息
				if ("1".equals(content)) {
					Article article = new Article();

					article.setTitle("微信公众帐号开发");
					article.setDescription("点击查看大图");
					article.setPicUrl("http://meizhuangge.duapp.com/images/shot_5.jpg");
					article.setUrl("http://meizhuangge.duapp.com/images/shot_5.jpg");

					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				// 单图文消息---不含图片
				else if ("2".equals(content)) {
					Article article = new Article();
					article.setTitle("Leevin百度相册");
					article.setDescription("点击进行访问");
					// 图文消息中可以使用QQ表情、符号表情
					// article.setDescription("柳峰，80后，" + emoji(0x1F6B9) +
					// 帐号开发经");
					// 将图片置为空
					article.setPicUrl("http://meizhuangge.duapp.com/images/shot_11.jpg");
					article.setUrl("http://xiangce.baidu.com/leevin");

					articleList.add(article);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				// 多图文消息
				else if ("3".equals(content)) {
					Article article1 = new Article();
					article1.setTitle("One\nLeevin个人空间");
					article1.setDescription("点击查看内容");
					article1.setPicUrl("http://meizhuangge.duapp.com/images/shot_5.jpg");
					article1.setUrl("http://hi.baidu.com/home");
					// article1.setUrl("http://www.baidu.com/p/%E4%BF%A1%E4%BB%A5%E4%B8%BA%E7%9C%9F2011?from=pic");

					Article article2 = new Article();
					article2.setTitle("Two\nGit使用");
					article2.setDescription("点击查看内容");
					article2.setPicUrl("http://meizhuangge.duapp.com/images/shot_6.jpg");
					article2.setUrl("http://wenku.baidu.com/view/83b3697da8956bec0975e38f?fr=prin");

					Article article3 = new Article();
					article3.setTitle("Three\n在Windows环境下使用Eclipse开发UNIX所需配置");
					article3.setDescription("点击查看内容");
					article3.setPicUrl("http://meizhuangge.duapp.com/images/shot_7.jpg");
					article3.setUrl("http://hi.baidu.com/duke_leevin/item/2a05653dbc66b59cc3cf297b");

					Article article4 = new Article();
					article4.setTitle("Four\nLeevin个人中心");
					article4.setDescription("点击查看内容");
					// 将图片置为空
					article4.setPicUrl("http://meizhuangge.duapp.com/images/shot_5.jpg");
					article4.setUrl("http://hi.baidu.com/duke_leevin");

					articleList.add(article1);
					articleList.add(article2);
					articleList.add(article3);
					articleList.add(article4);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				// 多图文消息--最后一条消息不含图片
				else if ("4".equals(content)) {
					Article article1 = new Article();
					article1.setTitle("Five\n软件截图");
					article1.setDescription("点击查看大图");
					article1.setPicUrl("http://meizhuangge.duapp.com/images/shot_1.jpg");
					article1.setUrl("http://meizhuangge.duapp.com/images/shot_1.jpg");

					Article article2 = new Article();
					article2.setTitle("Six\n软件截图");
					article2.setDescription("点击查看大图");
					article2.setPicUrl("http://meizhuangge.duapp.com/images/shot_2.jpg");
					article2.setUrl("http://meizhuangge.duapp.com/images/shot_2.jpg");

					Article article3 = new Article();
					article3.setTitle("Seven\n软件截图");
					article3.setDescription("点击查看大图");
					article3.setPicUrl("http://meizhuangge.duapp.com/images/shot_3.jpg");
					article3.setUrl("http://meizhuangge.duapp.com/images/shot_3.jpg");

					Article article4 = new Article();
					article4.setTitle("Eight\n软件截图");
					article4.setDescription("点击查看大图");
					article4.setPicUrl("http://meizhuangge.duapp.com/images/shot_4.jpg");
					article4.setUrl("http://meizhuangge.duapp.com/images/shot_4.jpg");

					articleList.add(article1);
					articleList.add(article2);
					articleList.add(article3);
					articleList.add(article4);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}

	/**
	 * emoji表情转换(hex -> UFT-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
}
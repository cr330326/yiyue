package net.cryallen.yiyue.bean.weixin;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/***
 Created by chenran on 2018/9/15.
 ***/
public class WeixinChoiceItemBean implements Serializable {
	@SerializedName("id")
	private String id;
	@SerializedName("title")
	private String title;
	@SerializedName("source")
	private String source;
	@SerializedName("firstImg")
	private String firstImg;
	@SerializedName("mark")
	private String mark;
	@SerializedName("url")
	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getFirstImg() {
		return firstImg;
	}

	public void setFirstImg(String firstImg) {
		this.firstImg = firstImg;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "WeixinChoiceItemBean{" +
				"id='" + id + '\'' +
				", title='" + title + '\'' +
				", source='" + source + '\'' +
				", firstImg='" + firstImg + '\'' +
				", mark='" + mark + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}

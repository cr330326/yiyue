package net.cryallen.yiyue.cache;

import net.cryallen.androidlib.utils.SpUtils;
import net.cryallen.yiyue.bean.douban.movie.child.SubjectsBean;

import java.util.List;

/***
 Created by chenran on 2018/9/17.
 ***/
public class DoubanCache {

	/**
	 * 获取豆瓣电影hot cache
	 *
	 * @return 豆瓣电影hot cache
	 */
	public static List<SubjectsBean> getHotMovieCache() {
		return SpUtils.getDataList("hot_movie_cache", SubjectsBean.class);
	}

	/**
	 * 保存豆瓣电影hot cache
	 */
	public static void saveHotMovieCache(List<SubjectsBean> list) {
		SpUtils.setDataList("hot_movie_cache", list);
	}
}

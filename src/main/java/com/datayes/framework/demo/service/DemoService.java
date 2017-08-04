package com.datayes.framework.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datayes.framework.exception.WebserviceException;
import com.datayes.framework.orm.dao.model.NewsMetadata;
import com.datayes.framework.orm.dao.model.news.NewsMapper;

@Service
public class DemoService {

	@Autowired
	private NewsMapper newsMapper;
	
	public String getUpperCase(String word) {
		// TODO Auto-generated method stub
		return word.toUpperCase();
	}

	public String getNewsTitleByNewsId(Long newsId) {
//		NewsMetadata news = newsMapper.selectNewsByNewsId(newsId);
//		return news.getNewsTitle();
		List<NewsMetadata> newsList = newsMapper.selectNewsByNewsId_List(newsId);
		if(newsList.size()>0)
			return newsList.get(0).getNewsTitle();
		else
			throw new WebserviceException("input incorrect");
	}
}

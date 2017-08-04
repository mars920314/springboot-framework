package com.datayes.framework.orm.dao.model.news;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.datayes.framework.orm.dao.model.NewsMetadata;


public interface NewsMapper {

	public NewsMetadata selectNewsByNewsId(@Param("newsId") Long newsId);

	/**
	 * @Results是以@Result为元素的数组，@Result表示单条属性-字段的映射关系
	 * @Result(id = true, property = "id", column = "test_id", javaType = String.class, jdbcType = JdbcType.VARCHAR)可以简写为：@Result(id = true, property = "id", column = "test_id")
	 * id = true表示这个test_id字段是个PK，查询时mybatis会给予必要的优化
	 * column表示数据库中的字段名称，property表示model的字段名称
	 */
    @Select("SELECT news_id, news_title FROM news_metadata WHERE news_Id = #{newsId}")
    @Results(value = { @Result(id = true, column = "news_id", property = "newsId", jdbcType = JdbcType.BIGINT),
                       @Result(column = "news_title", property = "newsTitle", jdbcType = JdbcType.VARCHAR) })
    public List<NewsMetadata> selectNewsByNewsId_List(@Param("newsId") Long newsId);
    
}

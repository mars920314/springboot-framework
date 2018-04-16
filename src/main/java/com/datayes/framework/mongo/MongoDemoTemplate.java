package com.datayes.framework.mongo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class MongoDemoTemplate {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<MongoDemoModel> findByMap(Map<String, Object> queryMap) {
		List<Criteria> criteriaList = queryMap.entrySet().stream()
				.map(entry -> Criteria.where(entry.getKey()).is(entry.getValue())).collect(Collectors.toList());
		Criteria criteria = new Criteria();
		Criteria[] criteriaArgs = new Criteria[criteriaList.size()];
		Query query = new Query(criteria.andOperator(criteriaList.toArray(criteriaArgs)));
		List<MongoDemoModel> list = mongoTemplate.find(query, MongoDemoModel.class, "screen_factor");
		return list;
	}

	public void updateByCode(Long code, String name) {
		Query query = new Query(Criteria.where("code").is(code));
		Update update = new Update().set("name", name);
		// 更新查询返回结果集的第一条
		mongoTemplate.updateFirst(query, update, MongoDemoModel.class);
		// 更新查询返回结果集的所有
		// mongoTemplate.updateMulti(query, update, MongoDemoModel.class);
	}

}

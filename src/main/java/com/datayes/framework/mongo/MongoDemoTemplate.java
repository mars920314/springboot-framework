package com.datayes.framework.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class MongoDemoTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

	public void SaveModel(MongoDemoModel model){
		mongoTemplate.save(model);
	}
	
	public void UpdateModel(MongoDemoModel model){
		Query query=new Query(Criteria.where("id").is(model.getId()));
		Update update= new Update().set("id", model.getId()).set("id", model.getId() + "x");
		//更新查询返回结果集的第一条
		mongoTemplate.updateFirst(query, update, MongoDemoModel.class);
		//更新查询返回结果集的所有
//		mongoTemplate.updateMulti(query, update, MongoDemoModel.class);
	}
	
	public MongoDemoModel FindModelById(String id){
		Query query=new Query(Criteria.where("id").is(id));
		MongoDemoModel user = mongoTemplate.findOne(query, MongoDemoModel.class);
		return user;
	}
	
	public void DeleteModelById(String id){
		Query query=new Query(Criteria.where("id").is(id));
		mongoTemplate.remove(query, MongoDemoModel.class);
	}

}

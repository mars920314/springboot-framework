package com.datayes.framework.mongo;

import org.springframework.beans.factory.annotation.Autowired;

public class MongoDemoImpl {

	@Autowired
	private MongoBaseRepository MongoBaseRepository;

	public void SaveModel(MongoDemoModel model){
		MongoBaseRepository.save(model);
	}
	
	public MongoDemoModel FindModelById(String id){
		MongoDemoModel user = MongoBaseRepository.FindById(id);
		return user;
	}
	
	public void DeleteModelById(String id){
		MongoBaseRepository.DeleteById(id);
	}
	
}

package com.datayes.framework.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoBaseRepository extends MongoRepository<MongoDemoModel, String> {

	void Save(MongoDemoModel model);
	
	MongoDemoModel FindById(String id);
	
	List<MongoDemoModel> findAll();
	
	MongoDemoModel FindByIdGreaterThan(String id);
	
	void DeleteById(String id);
}

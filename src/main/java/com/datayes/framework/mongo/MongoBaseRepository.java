package com.datayes.framework.mongo;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories("com.datayes.framework.mongo")
public interface MongoBaseRepository extends MongoRepository<MongoDemoModel, String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#save(S)
	 * 返回值为实际更新值，因为在实际插入过程中，数据可能改变 save如果带有id，则会检测id是否重复，若不重复则插入，若重复则更新
	 * save如果不带id，则和insert相同，仅插入数据
	 */
	MongoDemoModel save(MongoDemoModel model);

	MongoDemoModel insert(MongoDemoModel model);

	void deleteById(String id);

	List<MongoDemoModel> findAll();

	MongoDemoModel findByCodeAndName(Long code, String name);

	/*
	 * 详细方法参考： https://www.linuxidc.com/Linux/2012-06/61943p3.htm
	 * https://docs.spring.io/spring-data/data-commons/docs/1.7.x/reference/html/repositories.html
	 * 
	 */
	Page<MongoDemoModel> findByCodeGreaterThan(Long code, Pageable pageable);

	/*
	 * 此方法与FindByIdGreaterThan相同效果
	 */
	@Query(value = "{'code':{$gt:?0}}", fields = "{'code':1,'name':1}")
	MongoDemoModel findByCode(Long code);

	/*
	 * 可以在此定义接口，用MongoTemplate实现，到时候直接使用即可
	 */
	List<MongoDemoModel> findByMap(Map<String, Object> queryMap);

	void updateByCode(Long code, String name);
}

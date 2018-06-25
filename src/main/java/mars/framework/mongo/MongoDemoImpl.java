package mars.framework.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class MongoDemoImpl {

	@Autowired
	private MongoBaseRepository MongoBaseRepository;

	public void SaveModel(MongoDemoModel model) {
		MongoBaseRepository.save(model);
	}

	public List<MongoDemoModel> findByCodeGreaterThan(Long code) {
		PageRequest pager = new PageRequest(0, 100, Sort.Direction.DESC, "id");
		Page<MongoDemoModel> MongoDemoModelPages = MongoBaseRepository.findByCodeGreaterThan(code, pager);
		return MongoDemoModelPages.getContent();
	}

	public void updateNameById(Long code, String name) {
		MongoBaseRepository.updateByCode(code, name);
	}

}

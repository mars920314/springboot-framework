package mars.framework.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
	
	public String getUpperCase(String word) {
		// TODO Auto-generated method stub
		return word.toUpperCase();
	}
}

package io.snipped.rest.faq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqService {

	@Autowired
	private FaqRepository repository;
	
	public void insert(Faq faq) {
		repository.insert(faq);
	}
	
	public boolean delete(String id) {
		repository.deleteById(id);
		return true;
	}
	
	public List<Faq> getAllFaqs(){
		return repository.findAll();
	}
}

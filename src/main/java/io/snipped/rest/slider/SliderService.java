package io.snipped.rest.slider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SliderService {

	@Autowired
	private SliderRepository repository;
	
	public List<Slider> getAllImages(){
		return repository.findAll();
	}
}

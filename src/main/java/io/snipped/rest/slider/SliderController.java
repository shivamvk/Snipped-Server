package io.snipped.rest.slider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.snipped.rest.response.Response;

@RestController
public class SliderController {

	@Autowired
	private SliderService service;
	
	@GetMapping(value="/get_all_images")
	public Response getAllImages() {
		List<Slider> list = service.getAllImages();
		List<Object> responseList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			responseList.add(list.get(i));
		}
		
		Response response = new Response(200, responseList, "Okay");
		return response;
	}
}

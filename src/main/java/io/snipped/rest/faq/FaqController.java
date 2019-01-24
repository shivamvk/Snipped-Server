package io.snipped.rest.faq;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.snipped.rest.response.Response;;

@RestController
public class FaqController {

	@Autowired
	private FaqService service;
	
	@PostMapping(value="/faq")
	public Response insert(
			@RequestParam String ques,
			@RequestParam String ans) {
		Faq faq = new Faq(ObjectId.get(), ques, ans);
		service.insert(faq);
		List<Object> list = new ArrayList<>();
		list.add(faq);
		Response response = new Response(200, list, "Okay from shivamvk");
		return response;
	}
	
	@GetMapping(value="/faq")
	public Response getAllFaqs() {
		List<Faq> list = service.getAllFaqs();
		List<Object> responseList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			responseList.add(list.get(i));
		}
		Response response = new Response(200, responseList, "Okay from shivamvk");
		return response;
	}
	
	@DeleteMapping(value="faq")
	public String delete(@RequestParam String id) {
		service.delete(id);
		return "message : Okay from shivamvk";
	}
	
	
	
	
	
	
}

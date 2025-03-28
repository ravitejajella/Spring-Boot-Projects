package com.ravij.departmentapp;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DepartmentController {

	private RestClient restClient;
	
	public DepartmentController(RestClient.Builder builder) {
		this.restClient = builder.baseUrl("http://localhost:8090").build();
	}
	
	@GetMapping("/getEmployees")
	public List<String> getEmployees() {
		log.info("Running on the thread {}",Thread.currentThread());
		return restClient.get().uri("/employee").retrieve().toEntity(List.class).getBody();
	}
	
	
}

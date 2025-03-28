package com.ravij.blockingapp;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	
	@GetMapping("/employee")
	public List<String> getemployee() throws InterruptedException{
		Thread.sleep(1000);
		return List.of("Ravi","teja");
	}
}

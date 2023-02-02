package com.example.registrationlogindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessController {

	@GetMapping("/managers")
	public String showLeadersScreen() {
		return "managers";
	}
	
	@GetMapping("/employees")
	public String showEmployeeScreen() {
		return "employees";
	}
}

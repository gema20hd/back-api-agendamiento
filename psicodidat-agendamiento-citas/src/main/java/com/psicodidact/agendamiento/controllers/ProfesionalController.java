package com.psicodidact.agendamiento.controllers;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProfesionalController {
	
	@GetMapping("/profesinales")
	public String getAccountDetails(String input) {
		return "Here are the account details from the DB";
	}

}

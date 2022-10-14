package com.psicodidact.agendamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PsicodidatAgendamientoCitasApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(PsicodidatAgendamientoCitasApplication.class, args);
		System.out.println("Hola Mundo");
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "123456";

		for (int i = 0; i < 4; i++) {
			String passwordBcrypt = passwordEncoder.encode(password);
			System.out.println(passwordBcrypt);
		}

	}

}

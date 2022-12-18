package com.psicodidact.agendamiento;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class PsicodidatAgendamientoCitasApplication implements CommandLineRunner {

	@Autowired
	private  BCryptPasswordEncoder passwordEncoder;
	//static String usuarioC = "gema@uce.edu.ec";
	

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

	


	


	


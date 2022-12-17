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
	static String usuarioC = "gema@uce.edu.ec";
	

	public static void main(String[] args) {
		SpringApplication.run(PsicodidatAgendamientoCitasApplication.class, args);
		System.out.println("Hola Mundo");
		System.out.println("usaername: " + usuarioCorreo(usuarioC));
		
	}

	@Override
	public void run(String... args) throws Exception {

		String password = "12345";

		for (int i = 0; i < 4; i++) {
			String passwordBcrypt = passwordEn(password);
			System.out.println(passwordBcrypt);
		}

	}

	public static String usuarioCorreo(String u) {
		String[] usuario = null;
		usuario = u.split("@");
		String us = show(usuario);
		return us;

	}

	public static String show(String[] MyArray) {
		String t = "";
		for (int i = 0; i <= MyArray.length - 1; i++) {
			t = MyArray[0];
		}
		return t;
	}

	public String passwordEn(String password) {
		String passwordBcrypt = passwordEncoder.encode(password);
		return passwordBcrypt;
	}
	
	public static String getEdad(Date fechaNacimiento) {
	    if (fechaNacimiento != null) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        StringBuilder result = new StringBuilder();
	        if (fechaNacimiento != null) {
	            result.append(sdf.format(fechaNacimiento));
	            result.append(" (");
	            Calendar c = new GregorianCalendar();
	            c.setTime(fechaNacimiento);
	            result.append(calcularEdad(c));
	            result.append(" años)");
	        }
	        return result.toString();
	    }
	    return "";
	}

	private static int calcularEdad(Calendar fechaNac) {
	    Calendar today = Calendar.getInstance();
	    int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
	    int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
	    int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
	    // Si está en ese año pero todavía no los ha cumplido
	    if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
	        diffYear = diffYear - 1;
	    }
	    return diffYear;
	}
}

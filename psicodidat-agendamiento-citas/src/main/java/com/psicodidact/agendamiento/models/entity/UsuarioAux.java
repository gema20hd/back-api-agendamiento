package com.psicodidact.agendamiento.models.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioAux {

	@Autowired
	private  BCryptPasswordEncoder passwordEncoder;
	
	
	public String usuarioCorreo(String u) {
		String[] usuario = null;
		usuario = u.split("@");
		String us = username(usuario);
		return us;

	}

	public  String username(String[] MyArray) {
		String t = "";
		for (int i = 0; i <= MyArray.length - 1; i++) {
			t = MyArray[0];
		}
		return t;
	}

	public String passwordEncry(String password) {
		String passwordBcrypt = null;//passwordEncoder.encode(password);
		return passwordBcrypt;
	}

}

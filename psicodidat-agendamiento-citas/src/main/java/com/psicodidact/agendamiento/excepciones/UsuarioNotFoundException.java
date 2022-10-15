package com.psicodidact.agendamiento.excepciones;

public class UsuarioNotFoundException extends Exception {

	public UsuarioNotFoundException() {
		super("El usuario no existe en la base de datos");
	}
	
	
	public UsuarioNotFoundException(String mensaje) {
		super(mensaje);
	}
	
}

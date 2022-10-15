package com.psicodidact.agendamiento.excepciones;

public class UsuarioFoundException extends Exception{

	
	public UsuarioFoundException() {
		super("El usuario con ese nombre ya existe en la base de datos, vualva a intentar");
	}
	
	
	public UsuarioFoundException(String mensaje) {
		super(mensaje);
	}
	
}

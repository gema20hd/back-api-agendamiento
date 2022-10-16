package com.psicodidact.agendamiento.entidades.autoridades;

public class JwtResponse {

    private String token;

    public JwtResponse(String token) {
    	System.out.println("JwtResponse(String token)");
        this.token = token;
    }

    public JwtResponse() {
    	System.out.println("JwtResponse()");
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

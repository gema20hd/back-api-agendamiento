package com.psicodidact.agendamiento.entidades.autoridades;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    private String authority;

    public Authority(String authority) {
System.out.println("Authority(String authority)");
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
    	System.out.println(" String getAuthority()");
        return this.authority;
    }

}

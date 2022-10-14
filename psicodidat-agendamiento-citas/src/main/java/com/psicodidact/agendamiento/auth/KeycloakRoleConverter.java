package com.psicodidact.agendamiento.auth;


import java.util.Collection;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;



public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	@Override
	public Collection<GrantedAuthority> convert(Jwt source) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
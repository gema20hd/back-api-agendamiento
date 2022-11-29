package com.psicodidact.agendamiento.auth;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.services.IUsuarioService;



@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));
		
		info.put("nombre", usuario.getProfesional().getNombresProfesional());
		info.put("apellido paterno", usuario.getProfesional().getApellidoPaternoProfesional());
		info.put("apellido maternor", usuario.getProfesional().getApellidoMaternoProfesional());
		info.put("celular", usuario.getProfesional().getCelularProfesional());
		info.put("email", usuario.getProfesional().getCorreoElectronicoProfesional());
		//info.put("rol", usuario.getRoles());

		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}

package com.psicodidact.agendamiento.services;

import com.psicodidact.agendamiento.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}

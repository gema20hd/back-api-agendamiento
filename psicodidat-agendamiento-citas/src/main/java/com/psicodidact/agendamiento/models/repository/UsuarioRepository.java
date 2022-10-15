package com.psicodidact.agendamiento.models.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.psicodidact.agendamiento.models.entity.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);

}

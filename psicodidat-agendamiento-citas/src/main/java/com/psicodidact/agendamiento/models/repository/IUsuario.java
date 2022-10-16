package com.psicodidact.agendamiento.models.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.psicodidact.agendamiento.models.entity.Usuario;



public interface IUsuario extends JpaRepository<Usuario,Long> {

	@Query("select u from Usuario u where u.username=?1")
    public Usuario findByUsername(String username);

}

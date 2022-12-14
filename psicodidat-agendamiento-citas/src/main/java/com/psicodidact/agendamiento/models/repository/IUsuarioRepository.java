package com.psicodidact.agendamiento.models.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.psicodidact.agendamiento.models.entity.Rol;
import com.psicodidact.agendamiento.models.entity.Usuario;



public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

	@Query("select u from Usuario u where u.username=?1")
    public Usuario findByUsername(String username);
	

	 
	 @Query(value = "INSERT INTO usuarios_roles (id_usuario, id_rol) VALUES (:idUsuario, :idRol)", nativeQuery = true)
	 public Rol insertUsuarioRoles(@Param("idUsuario") Long idUsuario, @Param("idRol") Long idRol);
	 
	 
	 
}

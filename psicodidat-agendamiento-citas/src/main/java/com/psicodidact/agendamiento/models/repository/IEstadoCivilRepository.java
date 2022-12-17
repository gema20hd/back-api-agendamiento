package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.EstadoCivil;
import com.psicodidact.agendamiento.models.entity.Usuario;


public interface IEstadoCivilRepository extends CrudRepository<EstadoCivil, Long> {
	@Query("select b from EstadoCivil b where b.idEstadoCivil=?1")
    public EstadoCivil findByIdEstadoCivil(Long id);
	
	
}

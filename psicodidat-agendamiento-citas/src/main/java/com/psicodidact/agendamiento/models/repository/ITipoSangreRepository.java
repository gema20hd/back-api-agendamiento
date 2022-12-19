package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.TipoSangre;

public interface ITipoSangreRepository extends CrudRepository<TipoSangre, Long> {
	@Query("select b from TipoSangre b where b.idTipoSangre=?1")
	public TipoSangre findByIdTipoSangre(Long id);

}

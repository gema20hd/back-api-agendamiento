package com.psicodidact.agendamiento.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Banco;


public interface IBancoRepository  extends CrudRepository<Banco, Long>{
	
	public List<Banco> findByDescripcionBancoContainingIgnoreCase(String term);
	
	@Query("select b from Banco b where b.idBanco=?1")
	public Banco findByBank(Long id);

}

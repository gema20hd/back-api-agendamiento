package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Banco;


public interface IBancoRepository  extends CrudRepository<Banco, Long>{

}

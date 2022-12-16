package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.Compra;

public interface ICompraRepository extends CrudRepository<Compra, Long>{

}

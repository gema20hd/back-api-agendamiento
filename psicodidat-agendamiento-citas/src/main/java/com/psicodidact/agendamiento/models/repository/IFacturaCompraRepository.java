package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.FacturaCompra;


public interface IFacturaCompraRepository extends CrudRepository<FacturaCompra, Long>{

}

package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.ServicioCompra;

public interface IServicioCompraRepository extends CrudRepository<ServicioCompra, Long>{

}

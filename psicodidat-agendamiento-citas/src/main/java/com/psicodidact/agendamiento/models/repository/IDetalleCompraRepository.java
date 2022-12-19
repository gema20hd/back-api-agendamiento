package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.DetalleCompra;

public interface IDetalleCompraRepository extends CrudRepository<DetalleCompra, Long>{

}

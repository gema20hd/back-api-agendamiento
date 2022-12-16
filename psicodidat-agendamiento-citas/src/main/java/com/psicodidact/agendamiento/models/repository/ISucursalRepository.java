package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.Sucursal;

public interface ISucursalRepository extends CrudRepository<Sucursal, Long> {

}

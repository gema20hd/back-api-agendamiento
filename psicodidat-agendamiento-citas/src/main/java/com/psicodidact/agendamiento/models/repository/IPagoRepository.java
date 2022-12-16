package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.Pago;

public interface IPagoRepository extends CrudRepository<Pago, Long> {

}

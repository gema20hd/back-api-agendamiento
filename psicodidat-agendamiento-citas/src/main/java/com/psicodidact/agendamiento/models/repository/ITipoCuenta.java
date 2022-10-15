package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.TipoCuenta;

public interface ITipoCuenta  extends CrudRepository<TipoCuenta, Long> {

}

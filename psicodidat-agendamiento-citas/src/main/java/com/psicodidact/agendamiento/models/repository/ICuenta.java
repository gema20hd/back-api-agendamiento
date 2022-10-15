package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Cuenta;


public interface ICuenta extends CrudRepository<Cuenta, Long> {

}

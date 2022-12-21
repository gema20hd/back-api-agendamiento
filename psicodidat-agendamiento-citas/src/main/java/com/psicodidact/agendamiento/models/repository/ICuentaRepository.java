package com.psicodidact.agendamiento.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.Cuenta;
import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.TipoCuenta;


public interface ICuentaRepository extends CrudRepository<Cuenta, Long> {
	
@Query("select tc from TipoCuenta tc")
public List<TipoCuenta> findAllAccounType();

@Query("select b from Banco b")
public List<Banco> findAllBank();

@Query("select p from Cuenta p where p.numeroCuenta=?1")
public Cuenta findByNumeroCuenta(String nuemroCuenta);



}

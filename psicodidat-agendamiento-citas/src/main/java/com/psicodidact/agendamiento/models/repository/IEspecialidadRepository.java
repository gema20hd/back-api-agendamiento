package com.psicodidact.agendamiento.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.Cuenta;
import com.psicodidact.agendamiento.models.entity.Especialidad;
import com.psicodidact.agendamiento.models.entity.TipoCuenta;

public interface IEspecialidadRepository extends CrudRepository<Especialidad, Long>{

}




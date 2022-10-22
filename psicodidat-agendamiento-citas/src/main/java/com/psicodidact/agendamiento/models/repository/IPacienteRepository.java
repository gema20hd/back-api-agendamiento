package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Paciente;


public interface IPacienteRepository extends CrudRepository<Paciente, Long>{

}

package com.psicodidact.agendamiento.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.psicodidact.agendamiento.models.entity.UnidadEducativa;

public interface IUnidadEducativaRepository extends CrudRepository<UnidadEducativa, Long> {

@Query("SELECT ue FROM UnidadEducativa ue WHERE LOWER(ue.nombreUnidadEducativa) LIKE %:term%")
List<UnidadEducativa> findByNombreIgnoreCase(@Param("term") String term);
}

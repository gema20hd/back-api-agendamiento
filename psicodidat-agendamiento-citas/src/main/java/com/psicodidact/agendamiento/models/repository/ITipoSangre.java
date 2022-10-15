package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.TipoSangre;

public interface ITipoSangre extends CrudRepository<TipoSangre, Long> {

}

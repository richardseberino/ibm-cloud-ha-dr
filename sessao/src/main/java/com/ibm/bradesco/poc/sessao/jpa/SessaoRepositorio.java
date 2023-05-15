package com.ibm.bradesco.poc.sessao.jpa;

import com.ibm.bradesco.poc.sessao.dto.Sessao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepositorio extends CrudRepository<Sessao, String>  {
    
}

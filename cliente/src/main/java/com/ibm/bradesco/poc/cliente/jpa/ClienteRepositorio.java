package com.ibm.bradesco.poc.cliente.jpa;


import com.ibm.bradesco.poc.cliente.dto.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    

    Iterable<Cliente> findByNome(String nome);

    Iterable<Cliente> findByEmail(String email);

}

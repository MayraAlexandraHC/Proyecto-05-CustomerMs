package com.bank.CustomerMs.repository;

import com.bank.CustomerMs.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    boolean existsByDni(String dni);


    boolean existsByEmail(String email);
}

